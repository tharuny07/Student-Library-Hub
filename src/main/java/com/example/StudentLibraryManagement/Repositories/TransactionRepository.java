package com.example.StudentLibraryManagement.Repositories;

import com.example.StudentLibraryManagement.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Integer> {
}
