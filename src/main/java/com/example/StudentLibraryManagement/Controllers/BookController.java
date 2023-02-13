package com.example.StudentLibraryManagement.Controllers;

import com.example.StudentLibraryManagement.Models.Book;
import com.example.StudentLibraryManagement.Services.BookService;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Table(name="book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add-book")
    public String addBook(@RequestBody Book book){
       return bookService.addBook(book);
    }
}
