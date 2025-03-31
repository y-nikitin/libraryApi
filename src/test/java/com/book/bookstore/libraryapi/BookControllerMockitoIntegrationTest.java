package com.book.bookstore.libraryapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest
public class BookControllerMockitoIntegrationTest {

    @Mock
    private BookService bookService;

    private BookController bookController;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        bookController = new BookController(bookService);
    }

    @Test
    public void testGetBookById() throws ResouceNotFoundException {

        BookResponse expectedBookResponse = new BookResponse("getOneBook", LocalDate.of(1900, 8, 10), "John Doe");

        Mockito.when(bookService.getBookById(1L)).thenReturn(expectedBookResponse);

        BookResponse response = bookController.getBook(1);

        assertEquals(expectedBookResponse.getTitle(), response.getTitle());
        assertEquals(expectedBookResponse.getAuthorFullName(), response.getAuthorFullName());


    }
}
