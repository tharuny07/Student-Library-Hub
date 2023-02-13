package com.example.StudentLibraryManagement.Models;

import com.example.StudentLibraryManagement.Enums.Genre;
import jakarta.persistence.*;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int pages;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    //Book is child w.r.t author
    //Adding a foreign key column
    @ManyToOne
    @JoinColumn
    private Author author;

    //Book is also the child w.r.t card
    //Adding a foreign key column
    @ManyToOne
    @JoinColumn
    private Card card;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
