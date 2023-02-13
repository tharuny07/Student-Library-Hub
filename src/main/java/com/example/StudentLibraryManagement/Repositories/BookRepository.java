package com.example.StudentLibraryManagement.Repositories;

import com.example.StudentLibraryManagement.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
