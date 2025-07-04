package practico1;

import practico1.loan.LoanManager;
import practico1.model.Book;
import practico1.repository.ArrayListBookRepository;
import practico1.repository.BookRepository;

public class Main {
    public static void main(String[] args) {
        BookRepository repo = new ArrayListBookRepository();
        LoanManager loanManager = new LoanManager(repo);

        repo.addBook(new Book("123", "El Quijote", "Cervantes", 1605));
        repo.addBook(new Book("456", "Rayuela", "Cortázar", 1963));

        loanManager.loanBook("123");

    }
}
