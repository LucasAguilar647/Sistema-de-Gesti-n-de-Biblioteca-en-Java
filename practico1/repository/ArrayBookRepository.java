package practico1.repository;

import java.util.ArrayList;
import java.util.List;
import practico1.exception.LibraryException;
import practico1.model.Book;

public class ArrayBookRepository implements BookRepository {
    private final Book[] books;
    private int count = 0;

    public ArrayBookRepository(int size) {
        books = new Book[size];
    }

    public void addBook(Book book) {
        if (count >= books.length) throw new LibraryException("Repositorio lleno");

        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equals(book.getIsbn())) {
                throw new LibraryException("ISBN duplicado");
            }
        }

        books[count++] = book;
    }

    public void removeBook(String isbn) {
        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                books[i] = books[--count];
                books[count] = null;
                return;
            }
        }
        throw new LibraryException("Libro no encontrado");
    }

    public Book findByIsbn(String isbn) {
        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equals(isbn)) return books[i];
        }
        throw new LibraryException("Libro no encontrado");
    }

    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        for (int i = 0; i < count; i++) list.add(books[i]);
        return list;
    }
}

