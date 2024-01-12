package com.example.New_project.repository;

import com.example.New_project.model.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowerServiceRepo extends JpaRepository<BorrowedBook, Long> {
List<BorrowedBook> findBorrowedBooksByBookAuthor(String author);
List<BorrowedBook> findBorrowedBooksByBookName(String name);

}
