package com.example.New_project.controller;

import com.example.New_project.model.BookName;
import com.example.New_project.model.BorrowedBook;
import com.example.New_project.model.User;
import com.example.New_project.service.BookServices;
import com.example.New_project.service.BorrowedServices;
import com.example.New_project.service.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class BorrowedBooksController {

    @Autowired
    private BookServices bookServices;

    @Autowired
    private UserServices userServices;

    private final BorrowedServices borrowedServices;

    public BorrowedBooksController(BorrowedServices borrowedServices) {
        this.borrowedServices = borrowedServices;
    }

//    @GetMapping("/borrowedList/{id}")
//    public Map<String, Boolean> borrowedList (@PathVariable long id, @RequestBody List<BorrowedBook> borrowedBook){
//        BookName book = bookServices.findBookById(id);
//        LibraryUser library = libraryServices.findUserById(id);
//         borrowedBook = Collections.singletonList(new BorrowedBook(library.getId().toString(), book.getId().toString(), book.getTitle(), book.getAuthor()));
//        return  borrowedServices.saveAll(borrowedBook);
//    }

    @GetMapping("/borrowed")
    public ResponseEntity<List<BorrowedBook>> getAll (){
        return new ResponseEntity<>(borrowedServices.getAllBooks().getBody(), HttpStatus.OK);
    }
    @PostMapping("/borrowedList/")
    public BorrowedBook myList( long id ) {
        BookName book = bookServices.findBookById(id);
        User library = userServices.findUserById(id);
        BorrowedBook borrowedBook = new BorrowedBook(library.getId(),book.getId(),book.getTitle(), book.getAuthor());
       return borrowedServices.addUser(borrowedBook);
    }
@PostMapping("/addList")
    public String addToList(@RequestBody @Valid BorrowedBook borrowedBook){
         borrowedServices.addUser(borrowedBook);
    return  "added successfully";
}
@GetMapping("/borrow/{id}")
public BorrowedBook borrowedBookId(@PathVariable @Valid long id){
        return borrowedServices.borrowList(id);
}

    @PostMapping("/addAll")
    public ResponseEntity<Map<String, Boolean>> saveAll (@RequestBody List<BorrowedBook> borrowedBooks){
        return ResponseEntity.ok(borrowedServices.saveAll(borrowedBooks));
    }

}
