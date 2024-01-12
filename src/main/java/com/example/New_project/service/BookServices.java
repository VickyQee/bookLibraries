package com.example.New_project.service;

import com.example.New_project.exception.BookNotFoundException;
import com.example.New_project.model.BookName;
import com.example.New_project.repository.BookNameRepo;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class BookServices {
    private final BookNameRepo bookNameRepo;

    public BookServices(BookNameRepo bookNameRepo) {
        this.bookNameRepo = bookNameRepo;
    }

    public ResponseEntity<List<BookName>> getAllBooks (){
        return ResponseEntity.ok(bookNameRepo.findAll());
    }
    public BookName addBook (@Valid BookName bookName){
        return bookNameRepo.save(bookName);
    }
    public Map<String, Boolean> saveAllBooks (List<BookName> bookName){
        Map<String, Boolean> responseMap = new HashMap<>();
        for (BookName users : bookName)
            responseMap.put(users.getAuthor() + "books added successfully", true);
        bookNameRepo.saveAll(bookName);
        return responseMap;
    }
    public BookName findBookById(long id){
        return bookNameRepo.findById(id).orElseThrow(()-> new BookNotFoundException("Book not available"));
    }
    public List<BookName> findBookByTitle (String title){
        return bookNameRepo.findBookByTitle(title);
    }
    public List<BookName> findBookByIsbn (String isbn){
        return bookNameRepo.findBookByIsbn(isbn);
    }
public BookName findBookByAuthor (String author) {return bookNameRepo.findBookByAuthor(author);}
    public BookName deleteBook ( long id){
        BookName user = findBookById(id);
        bookNameRepo.delete(user);
        return user;
    }
    public BookName borrowBook(long id){
        return bookNameRepo.getReferenceById(id);
    }

}
