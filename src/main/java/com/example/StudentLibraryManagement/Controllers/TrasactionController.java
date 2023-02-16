package com.example.StudentLibraryManagement.Controllers;

import com.example.StudentLibraryManagement.DTOs.IssueBookRequestDto;
import com.example.StudentLibraryManagement.Services.TrasactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")

public class TrasactionController {
    @Autowired
    TrasactionService trasactionService;

    @PostMapping("/issueBook")
    public String issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto)
    {
        return trasactionService.issueBook(issueBookRequestDto);
    }
}
