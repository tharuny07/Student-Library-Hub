package com.example.StudentLibraryManagement.Services;

import com.example.StudentLibraryManagement.DTOs.IssueBookRequestDto;
import com.example.StudentLibraryManagement.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrasactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public String issueBook(IssueBookRequestDto issueBookRequestDto){
        return "";
    }

}
