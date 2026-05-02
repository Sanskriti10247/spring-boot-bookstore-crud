package com.project.bookstore.service;

import com.project.bookstore.model.Author;
import com.project.bookstore.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository repo;

    public AuthorService(AuthorRepository repo) {
        this.repo = repo;
    }

    public List<Author> getAllAuthors() {
        return repo.findAll();
    }
}