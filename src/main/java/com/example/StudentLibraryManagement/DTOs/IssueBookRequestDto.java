package com.example.StudentLibraryManagement.DTOs;

public class IssueBookRequestDto {
    private int cardId;
    private int bookId;

    public IssueBookRequestDto() {
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
