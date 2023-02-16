package com.example.StudentLibraryManagement.Services;

import com.example.StudentLibraryManagement.DTOs.AuthorEntryDto;
import com.example.StudentLibraryManagement.Models.Author;
import com.example.StudentLibraryManagement.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
