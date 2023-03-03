package com.example.StudentLibraryManagement.Controllers;

import com.example.StudentLibraryManagement.DTOs.IssueBookRequestDto;
import com.example.StudentLibraryManagement.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")

public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/issueBook")
    public String issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) {

        try {
            return transactionService.issueBook(issueBookRequestDto);
        }
        catch (Exception e) {
            return e.getMessage();
        }

    }
    @GetMapping("/getTxnInfo")
    public String getTransactionEntry(@RequestParam("bookId") int bookId,@RequestParam("cardId") int cardId)
    {
        return transactionService.getTransactions(bookId,cardId);
    }
}
