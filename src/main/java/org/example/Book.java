package org.example;

import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Judul harus diisi");
        }
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author harus diisi");
        }
        if (year < 2000 || year > 2100) {
            throw new IllegalArgumentException("Tahun hanya bisa diisi dari tahun 2000 sampai 2100");
        }

        this.title = title.trim();
        this.author = author.trim();
        this.year = year;
    }

    // Getter sesuai dengan unit test
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%s by %s (%d)", title, author, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return year == book.year &&
                title.equals(book.title) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}