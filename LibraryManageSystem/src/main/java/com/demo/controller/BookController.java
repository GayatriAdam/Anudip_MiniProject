package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Book;
import com.demo.service.BookService;

@RestController
@RequestMapping("/books") // base URL
public class BookController {

    @Autowired
    private BookService service;

    // ✅ POST request to add a book
    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    // ✅ GET request to list all books
    @GetMapping("/all")
    public List<Book> listBooks() {
        return service.getAllBooks();
    }

    // ✅ DELETE request to delete a book by ID
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return "Book deleted with id: " + id;
    }
}