package com.example.StudentLibraryManagement.Services;

import com.example.StudentLibraryManagement.DTOs.BookRequestDto;
import com.example.StudentLibraryManagement.Models.Author;
import com.example.StudentLibraryManagement.Models.Book;
import com.example.StudentLibraryManagement.Repositories.AuthorRepository;
import com.example.StudentLibraryManagement.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;

    public String addBook(BookRequestDto bookReq)
    {
        //getting the author id from the user input
        int authorId=bookReq.getAuthorId();

        //Finding author entity using the authorId we got
        Author author=authorRepository.findById(authorId).get();
        //setting up the foreign key attribute
        Book book=new Book();
        book.setName(bookReq.getName());
        book.setRating(bookReq.getRating());
        book.setGenre(bookReq.getGenre());
        book.setPages(bookReq.getPages());
        book.setAuthor(author);

        //Updating booksWriiten by the author
        List<Book> booksWritten=author.getBooksWritten();
        //Adding the current book to update booksWritten
        booksWritten.add(book);

        //Since we are using bidirectional mapping book is saved automatically
        //Due to thecascade effect
        //Updating the author entity
        authorRepository.save(author);

        return "Book added succesfully";
    }
}
