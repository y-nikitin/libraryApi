package com.book.bookstore.libraryapi;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookDTO {

    @NotNull(message = "Tittle cannot be empty")
    private String title;
    @Past(message = "Publication Date cannot be the present day")
    private LocalDate publicationDate;
    @Positive
    private int pages;
    private int price;
    private Long authorId;
}
