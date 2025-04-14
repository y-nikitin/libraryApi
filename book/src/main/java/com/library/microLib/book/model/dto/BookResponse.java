package com.library.microLib.book.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class BookResponse {

    private String title;
    private LocalDate publicationDate;
    private String authorFullName;
}
