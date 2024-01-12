package com.example.New_project.service;

import com.example.New_project.exception.BookNotFoundException;
import com.example.New_project.model.BorrowedBook;
import com.example.New_project.repository.BorrowerServiceRepo;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BorrowedServices {


    private  final BorrowerServiceRepo borrowerServiceRepo;


    public BorrowedServices(BorrowerServiceRepo borrowerServiceRepo) {
        this.borrowerServiceRepo = borrowerServiceRepo;
    }
    public ResponseEntity<List<BorrowedBook>> getAllBooks (){
        return ResponseEntity.ok(borrowerServiceRepo.findAll());
    }
    public BorrowedBook borrowList (@Valid long id){
      return   borrowerServiceRepo.findById(id).orElseThrow(()-> new BookNotFoundException("out of bound"));
    }
    public BorrowedBook bookId(@Valid long id){
        return borrowerServiceRepo.findById(id).orElseThrow(()-> new BookNotFoundException("Book not found"));
    }
    public BorrowedBook userId (@Valid long id ){
        return borrowerServiceRepo.findById(id).orElseThrow(()-> new BookNotFoundException(("User not found")));
    }
    public Map<String, Boolean>  saveAll (@RequestBody List<BorrowedBook> borrowedBook){
        Map<String, Boolean> response = new HashMap<>();
        for (BorrowedBook books : borrowedBook)
            response.put(books.getBookName() +"books saved successfully", true);
        return response;
    }
    public BorrowedBook addUser( @RequestBody BorrowedBook borrowedBook){
        return borrowerServiceRepo.save(borrowedBook);
    }
public List<BorrowedBook> findBorrowedBooksByBookAuthor (String author){
        return borrowerServiceRepo.findBorrowedBooksByBookAuthor(author);
}
public List<BorrowedBook> findBorrowedBooksByBookName (String name){
        return borrowerServiceRepo.findBorrowedBooksByBookName(name);
}
}
