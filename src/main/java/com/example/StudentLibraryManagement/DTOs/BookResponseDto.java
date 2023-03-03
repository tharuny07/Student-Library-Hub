package com.example.StudentLibraryManagement.DTOs;

import com.example.StudentLibraryManagement.Enums.Genre;

public class BookResponseDto {
    private String name;
    private Genre genre;
    private int pages;

    public BookResponseDto(){

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
