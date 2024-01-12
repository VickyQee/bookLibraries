package com.example.New_project.repository;

import com.example.New_project.model.BookName;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookNameRepo extends JpaRepository<BookName, Long> {


    List<BookName> findBookByTitle(String title);
    List<BookName> findBookByIsbn(String isbn);

    BookName findBookByAuthor(String author);
}
