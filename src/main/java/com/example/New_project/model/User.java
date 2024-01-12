package com.example.New_project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@Entity()
@Table(name = "library_user", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "full_Name")
    private String fullName;

@Email(message = "enter a valid name" )
    private String email;


@Min(value = 18, message = "you must be 18 and below")
@Max(value = 70, message = "you're overAge")
    private int age;

@Length(min = 4, message = "address can't be less that 4 character")
@Length(max = 25, message = "address can't be more that 25 character")
    private String address;

    public User(String fullName, String email, int age, String address) {
        this.fullName = fullName;
        this.email = email;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "LibraryUser{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
