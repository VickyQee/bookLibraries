package com.example.New_project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "borrowed_Book")
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//        @JoinTable(name = "user_Id", joinColumns = {@JoinColumn(name = "book_name",referencedColumnName = "id")},
//        inverseJoinColumns = {@JoinColumn(name = "borrow_book",referencedColumnName = "id")})
//    private LibraryUser user;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id",referencedColumnName = "id")
//    private LibraryUser libraryUser;



    @Column(name = "user_Id")
    private Long userId;
    @Column(name = "book_Id")
    private Long bookId;
    @Column(name = "book_Name")
    private String bookName;
    @Column(name = "book_Author")
    private String bookAuthor;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private List<BookName> bookNames;

    public BorrowedBook(Long userId, Long bookId, String bookName, String bookAuthor) {
        this.userId = userId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }

    @Override
    public String toString() {
        return "BorrowedBook{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                '}';
    }
}
