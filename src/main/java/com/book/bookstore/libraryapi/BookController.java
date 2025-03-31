package com.book.bookstore.libraryapi;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Validated
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookResponse> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookResponse getBook(@PathVariable int id) throws ResouceNotFoundException {
        BookResponse response = bookService.getBookById(id);
        if (response == null) {
            throw new ResouceNotFoundException("No Book found");
        }
        return response;
    }

    @PostMapping
    public Book addBook(@Valid @RequestBody BookDTO bookDTO) throws Exception {
        return bookService.addBook(bookDTO);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }
}
