package org.example;

import org.example.Book;
import org.example.BookManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookManagerTest {
    private BookManager bookManager;

    @BeforeEach
    void setup() {
        bookManager = new BookManager();
    }

    @Test
    @DisplayName("Test menambahkan buku")
    void testAddBook() {
        Book buku = new Book("Pemrograman", "Andi", 2020);
        bookManager.addBook(buku);

        assertEquals(1, bookManager.getBookCount(),
                "Jumlah buku seharusnya 1 setelah menambahkan buku");
    }

    @Test
    @DisplayName("Test menghapus buku yang ada")
    void testRemoveExistingBook() {
        Book buku = new Book("Basis Data", "ErLangga", 2021);
        bookManager.addBook(buku);

        boolean removed = bookManager.removeBook("Basis Data");

        assertTrue(removed, "Buku seharusnya berhasil dihapus");
        assertEquals(0, bookManager.getBookCount(),
                "Jumlah buku seharusnya 0 setelah dihapus");
    }

    @Test
    @DisplayName("Test menghapus buku yang tidak ada")
    void testRemoveNonExistingBook() {
        Book buku = new Book("Algoritma", "Budi", 2019);
        bookManager.addBook(buku);

        boolean removed = bookManager.removeBook("Struktur Data");

        assertFalse(removed, "Seharusnya return false karena buku tidak ada");
        assertEquals(1, bookManager.getBookCount(),
                "Jumlah buku seharusnya tetap 1 karena buku yang dihapus tidak ada");
    }

    @Test
    @DisplayName("Test mencari buku berdasarkan author")
    void testFindBooksByAuthor() {
        bookManager.addBook(new Book("Pemrograman Java", "Andi", 2020));
        bookManager.addBook(new Book("Pemrograman Python", "Andi", 2021));
        bookManager.addBook(new Book("Desain UI/UX", "Budi", 2022));

        List<Book> result = bookManager.findBooksByAuthor("Andi");

        assertEquals(2, result.size(),
                "Seharusnya ada 2 buku dari author Andi");
        assertTrue(result.stream().allMatch(b -> b.getAuthor().equals("Andi")),
                "Semua buku hasil pencarian harus dari author Andi");
    }

    @Test
    @DisplayName("Test mendapatkan semua buku")
    void testGetAllBooks() {
        bookManager.addBook(new Book("Jaringan Komputer", "Tono", 2018));
        bookManager.addBook(new Book("AI Modern", "Rina", 2022));

        List<Book> allBooks = bookManager.getAllBooks();

        assertEquals(2, allBooks.size(),
                "Jumlah buku seharusnya 2");
        assertNotNull(allBooks.get(0),
                "Buku pertama tidak boleh null");
        assertNotNull(allBooks.get(1),
                "Buku kedua tidak boleh null");
    }
}