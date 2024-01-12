package com.example.New_project.controller;

import com.example.New_project.model.BookName;
import com.example.New_project.service.BookServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class BookController {
    private final BookServices bookServices;

    public BookController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookName>> getAll (){
        return new ResponseEntity<>(bookServices.getAllBooks().getBody(), HttpStatus.OK);
    }
    @PostMapping("/addBooks")
    public ResponseEntity<BookName> addBook ( @RequestBody BookName bookName){
        return ResponseEntity.ok(bookServices.addBook(bookName));
    }
    @PostMapping("/allBooks")
    public ResponseEntity<Map<String, Boolean>> saveAll (@RequestBody List<BookName> bookNames){
        return ResponseEntity.ok(bookServices.saveAllBooks(bookNames));
    }
    @GetMapping("/books/id/{id}")
    public BookName findBookById ( @PathVariable long id){
        return bookServices.findBookById(id);
    }
    @DeleteMapping("/deleteBooks/{id}")
    public ResponseEntity<BookName> deleteBooks ( @PathVariable long id ){
        return ResponseEntity.ok(bookServices.deleteBook(id));
    }
    @GetMapping("/books/title/{title}")
    public List<BookName> findBookByTitle (@PathVariable @Valid String title){
        return bookServices.findBookByTitle(title);
    }
    @GetMapping("/books/isbn/{isbn}")
    public List<BookName> findBookByIsbn ( @PathVariable @Valid String isbn){
        return bookServices.findBookByIsbn(isbn);
    }
    @GetMapping("/books/author/{author}")
    public BookName findBookByAuthor (@PathVariable @Valid String author){
        return bookServices.findBookByAuthor(author);
    }


}
