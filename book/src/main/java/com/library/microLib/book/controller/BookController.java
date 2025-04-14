package com.library.microLib.book.controller;

import com.library.microLib.book.model.Book;
import com.library.microLib.book.model.dto.BookResponse;
import com.library.microLib.book.service.BookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookController {

    BookService bookService;

    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }
}
