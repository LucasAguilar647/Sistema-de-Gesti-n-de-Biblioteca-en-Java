package practico1.filter;


import java.util.List;
import practico1.model.Book;


public interface BookFilter {
    List<Book> filter(List<Book> books);
}

