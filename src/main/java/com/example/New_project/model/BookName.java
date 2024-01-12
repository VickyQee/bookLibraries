package com.example.New_project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "book_Name")
public class BookName {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

   private String title;

    private String author;

    @Pattern(regexp = "[a-z]{3}-[0-9]{3}")
    @Column(unique = true)
    private String isbn;

@Column(name = "publication_year")
    private String publicationYear;

    public BookName(String title, String author, String isbn, String publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "BookName{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn=" + isbn +
                ", publicationYear='" + publicationYear + '\'' +
                '}';
    }
}
