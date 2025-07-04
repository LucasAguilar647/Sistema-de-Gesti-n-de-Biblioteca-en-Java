package practico1.repository;

import java.util.ArrayList;
import java.util.List;
import practico1.exception.LibraryException;
import practico1.model.Book;


public class ArrayListBookRepository implements BookRepository {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (books.stream().anyMatch(b -> b.getIsbn().equals(book.getIsbn()))) {
            throw new LibraryException("ISBN duplicado");
        }
        books.add(book);
    }

    public void removeBook(String isbn) {
        Book book = findByIsbn(isbn);
        books.remove(book);
    }

    public Book findByIsbn(String isbn) {
        return books.stream()
            .filter(b -> b.getIsbn().equals(isbn))
            .findFirst()
            .orElseThrow(() -> new LibraryException("Libro no encontrado"));
    }

    public List<Book> findAll() {
        return new ArrayList<>(books);
    }
}
