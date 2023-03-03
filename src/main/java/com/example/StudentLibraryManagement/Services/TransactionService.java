package com.example.StudentLibraryManagement.Services;

import com.example.StudentLibraryManagement.DTOs.IssueBookRequestDto;
import com.example.StudentLibraryManagement.Enums.CardStatus;
import com.example.StudentLibraryManagement.Enums.TransactionStatus;
import com.example.StudentLibraryManagement.Models.Book;
import com.example.StudentLibraryManagement.Models.Card;
import com.example.StudentLibraryManagement.Models.Transactions;
import com.example.StudentLibraryManagement.Repositories.BookRepository;
import com.example.StudentLibraryManagement.Repositories.CardRepository;
import com.example.StudentLibraryManagement.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;

    public String issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception{

        int bookId= issueBookRequestDto.getBookId();
        int cardId=issueBookRequestDto.getCardId();

        Book book=bookRepository.findById(bookId).get();
        Card card=cardRepository.findById(cardId).get();

        Transactions transaction=new Transactions();

        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setIssueOperation(true);
        transaction.setTransactionStatus(TransactionStatus.PENDING);
        transaction.setTransactionId(UUID.randomUUID().toString());

        if(book==null||book.isIssued()==true)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not available");
        }
        if(card==null||card.getCardStatus()!= CardStatus.ACTIVATED)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not valid");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);

        List<Transactions> transactionsListForCard=card.getTransactionsList();
        transactionsListForCard.add(transaction);
        card.setTransactionsList(transactionsListForCard);

        List<Transactions> transactionsListForBook=book.getTransactionList();
        transactionsListForBook.add(transaction);
        book.setTransactionList(transactionsListForBook);

        cardRepository.save(card);




        return "Book issued successfully";
    }

    public String getTransactions(int bookId,int cardId)
    {
        List<Transactions> transactionsList=transactionRepository.getTransactionsForBookAndCard(bookId,cardId);

        String transactionId=transactionsList.get(0).getTransactionId();

        return transactionId;
    }

}
