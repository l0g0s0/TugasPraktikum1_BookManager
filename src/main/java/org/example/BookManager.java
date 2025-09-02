package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookManager {
    private final List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Buku tidak boleh null");
        }
        // Cegah duplikasi berdasarkan title + author + year
        if (!books.contains(book)) {
            books.add(book);
        }
    }

    public boolean removeBook(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Judul tidak boleh kosong");
        }
        return books.removeIf(buku ->
                buku.getTitle().equalsIgnoreCase(title.trim()));
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public List<Book> findBooksByAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author tidak boleh kosong");
        }
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author.trim()))
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByYear(int year) {
        if (year < 2000 || year > 2100) {
            throw new IllegalArgumentException("Tahun hanya bisa diisi dari 2000 sampai 2100");
        }
        return books.stream()
                .filter(book -> book.getYear() == year)
                .collect(Collectors.toList());
    }

    public int getBookCount() {
        return books.size();
    }

    public boolean containsBook(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Judul tidak boleh kosong");
        }
        return books.stream()
                .anyMatch(book -> book.getTitle().equalsIgnoreCase(title.trim()));
    }

    public void clearAllBooks() {
        books.clear();
    }
}