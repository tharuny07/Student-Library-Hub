package com.example.StudentLibraryManagement.Controllers;

import com.example.StudentLibraryManagement.DTOs.AuthorEntryDto;
import com.example.StudentLibraryManagement.DTOs.AuthorResponseDto;
import com.example.StudentLibraryManagement.Models.Author;
import com.example.StudentLibraryManagement.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add-author")
    public String addAuthor(@RequestBody AuthorEntryDto author){
        return authorService.addAuthor(author);
    }
    @GetMapping("/getAuthor")
    public AuthorResponseDto getAuthor(@RequestParam("authorId") int authorId)
    {
       return authorService.getAuthor(authorId);
    }
}
