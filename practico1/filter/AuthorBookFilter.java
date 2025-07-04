package practico1.filter;

import java.util.List;
import java.util.stream.Collectors;
import practico1.model.Book;

public class AuthorBookFilter implements BookFilter {
    private String author;

    public AuthorBookFilter(String author) {
        this.author = author;
    }

    public List<Book> filter(List<Book> books) {
        return books.stream()
            .filter(book -> book.getAuthor().equalsIgnoreCase(author))
            .collect(Collectors.toList()); 
    }
}

