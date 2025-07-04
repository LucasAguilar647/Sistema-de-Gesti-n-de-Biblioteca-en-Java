package practico1.model;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean available;

    public Book(String isbn, String title, String author, int year) {
        if (isbn == null || isbn.isEmpty()) throw new IllegalArgumentException("ISBN inválido");
        if (year < 0) throw new IllegalArgumentException("Año no puede ser negativo");
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("Título inválido o vacío");    
        if (author == null || author.isEmpty()) throw new IllegalArgumentException("Autor inválido o vacío");   


        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;
        return isbn.equals(((Book) obj).isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }

    @Override
    public String toString() {
    return "Título: " + title + ", Autor: " + author + ", ISBN: " + isbn + ", Año: " + year + ", Disponible: " + available;
    }

}
