package com.book.bookstore.libraryapi;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "book")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private LocalDate publicationDate;
    private int pages;
    private int price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
