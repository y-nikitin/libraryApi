package com.book.bookstore.libraryapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class BookMapperUnitTest {

    @Test
    void testBookToBookResponse_Successful() {
        Book book = Book.builder()
                .title("TestBook")
                .price(100)
                .pages(300)
                .publicationDate(LocalDate.of(1970, 3, 20))
                .build();

        BookResponse response = BookMapper.INSTANCE.toBookResponse(book);

        Assertions.assertNotNull(response);
        Assertions.assertEquals("TestBook", response.getTitle());
        Assertions.assertEquals(LocalDate.of(1970, 3, 20), response.getPublicationDate());
        Assertions.assertNull(response.getAuthorFullName());
    }

    @Test
    void testBookToBookResponseWithNullBody() {
        Book book = null;
        BookResponse response = BookMapper.INSTANCE.toBookResponse(book);
        Assertions.assertNull(response);
    }
}
