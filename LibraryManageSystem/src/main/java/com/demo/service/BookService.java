package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.BookRepository;
import com.demo.model.Book;

@Service
public class BookService {
    
    @Autowired
    private BookRepository repo;

    public Book saveBook(Book book) {
        return repo.save(book);
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public void deleteBook(Long id) {
        repo.deleteById(id);
    }
}