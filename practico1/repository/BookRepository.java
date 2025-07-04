package practico1.repository;

import java.util.List;
import practico1.model.Book;


public interface BookRepository {
    void addBook(Book book);
    void removeBook(String isbn);
    Book findByIsbn(String isbn);
    List<Book> findAll();
}

