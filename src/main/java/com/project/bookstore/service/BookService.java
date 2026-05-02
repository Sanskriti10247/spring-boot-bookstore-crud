package com.project.bookstore.service;

import com.project.bookstore.model.Book;
import com.project.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public List<Book> getBooksWithAuthors() {
        return repo.findBooksWithAuthors();
    }

    public Book save(Book book) {
        return repo.save(book);
    }

    // ✅ FIXED (IMPORTANT)
    public Book getBookById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
    }

    // ✅ UPDATE METHOD (clean)
    public void updateBook(Book updatedBook) {
        Book existing = getBookById(updatedBook.getId());

        existing.setTitle(updatedBook.getTitle());
        existing.setPrice(updatedBook.getPrice());
        existing.setAuthor(updatedBook.getAuthor());

        repo.save(existing);
    }
}