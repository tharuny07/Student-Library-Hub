package com.example.StudentLibraryManagement.Services;

import com.example.StudentLibraryManagement.DTOs.AuthorEntryDto;
import com.example.StudentLibraryManagement.DTOs.AuthorResponseDto;
import com.example.StudentLibraryManagement.DTOs.BookResponseDto;
import com.example.StudentLibraryManagement.Models.Author;
import com.example.StudentLibraryManagement.Models.Book;
import com.example.StudentLibraryManagement.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public String addAuthor(AuthorEntryDto authorObj)
    {
        Author author=new Author();
        author.setAge(authorObj.getAge());
        author.setCountry(authorObj.getCountry());
        author.setName(authorObj.getName());

        authorRepository.save(author);
        return "Author added successfully";
    }
    public AuthorResponseDto getAuthor(int authorId)
    {
        Author author=authorRepository.findById(authorId).get();

        AuthorResponseDto authorResponseDto=new AuthorResponseDto();
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setCountry(author.getCountry());
        authorResponseDto.setName(author.getName());

        List<Book> booksWritten= author.getBooksWritten();
        List<BookResponseDto> booksWrittenDto=new ArrayList<>();

        for(Book b:booksWritten)
        {
            BookResponseDto bookResponseDto=new BookResponseDto();
            bookResponseDto.setGenre(b.getGenre());
            bookResponseDto.setPages(b.getPages());
            bookResponseDto.setName(b.getName());

            booksWrittenDto.add(bookResponseDto);
        }
        authorResponseDto.setBooksWritten(booksWrittenDto);

        return authorResponseDto;
    }
}
