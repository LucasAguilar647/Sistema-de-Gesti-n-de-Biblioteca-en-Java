package practico1;

import practico1.exception.LibraryException;
import practico1.loan.LoanManager;
import practico1.model.Book;
import practico1.repository.ArrayListBookRepository;
import practico1.repository.BookRepository;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            BookRepository repo = new ArrayListBookRepository();
            
        
            Book b1 = new Book("001", "Clean Code", "Robert Martin", 2008);
            Book b2 = new Book("002", "El progamador pragmatico", "Joshua Bloch", 2018);
            Book b3 = new Book("003", "Deep work", "Brian Goetz", 2006);

            repo.addBook(b1);
            repo.addBook(b2);
            repo.addBook(b3);
            
            System.out.println("Libros agregados correctamente.\n");

           
            LoanManager loanManager = new LoanManager(repo);

          
            loanManager.loanBook("002");
            System.out.println("Libro prestado: " + b2.getTitle());

        
            try {
                loanManager.loanBook("002");
            } catch (LibraryException e) {
                System.out.println("Error al prestar libro ya prestado: " + e.getMessage());
            }

         
            loanManager.returnBook("002");
            System.out.println("Libro devuelto: " + b2.getTitle());

            
            try {
                loanManager.returnBook("999");
            } catch (LibraryException e) {
                System.out.println("Error con ISBN inexistente: " + e.getMessage());
            }


            List<Book> librosDisponibles = repo.findAll();
            System.out.println("\nLibros disponibles:");
            for (Book book : librosDisponibles) {
                System.out.println(book); 
            }
            

        } catch (LibraryException e) {
            System.out.println("Error general: " + e.getMessage());
        }
    }
}

