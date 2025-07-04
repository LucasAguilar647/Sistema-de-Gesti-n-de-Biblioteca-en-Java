package practico1.loan;

import practico1.exception.LibraryException;
import practico1.model.Book;
import practico1.repository.BookRepository;

public class LoanManager {
    private BookRepository repository;

    public LoanManager(BookRepository repository) {
        this.repository = repository;
    }

    public void loanBook(String isbn) {
        Book book = repository.findByIsbn(isbn);
        if (!book.isAvailable()) {
            throw new LibraryException("El libro ya está prestado");
        }
        book.setAvailable(false);
    }

    public void returnBook(String isbn) {
        Book book = repository.findByIsbn(isbn);
        book.setAvailable(true);
    }
}

