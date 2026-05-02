package com.project.bookstore.controller;

import com.project.bookstore.model.Book;
import com.project.bookstore.service.AuthorService;
import com.project.bookstore.service.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    //  SHOW ADD FORM
    @GetMapping("/addBook")
    public String showForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "add-book";
    }

    //  SAVE BOOK
    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/books";
    }

    // LIST BOOKS
    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getBooksWithAuthors());
        return "list-books";
    }

    // EDIT BOOK
    @GetMapping("/editBook/{id}")
    public String editBook(@PathVariable Long id, Model model) {

        Book book = bookService.getBookById(id);

        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.getAllAuthors());

        return "edit-book";
    }

    //  UPDATE BOOK
    @PostMapping("/updateBook")
    public String updateBook(@ModelAttribute Book book) {
        bookService.updateBook(book);
        return "redirect:/books";
    }
}