package com.example.StudentLibraryManagement.DTOs;

import java.util.ArrayList;
import java.util.List;

public class AuthorResponseDto {
    private String name;
    private String country;
    private int age;
    private List<BookResponseDto> booksWritten;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<BookResponseDto> getBooksWritten() {
        return booksWritten;
    }

    public void setBooksWritten(List<BookResponseDto> booksWritten) {
        this.booksWritten = booksWritten;
    }
}