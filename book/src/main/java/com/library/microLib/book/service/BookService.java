package com.library.microLib.book.service;

import com.library.microLib.book.model.Book;
import com.library.microLib.book.model.dto.BookResponse;
import com.library.microLib.book.repository.BookRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookService {

    BookRepository bookRepository;

    RestTemplate restTemplate;

    public BookResponse getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();

        String authorFullName = restTemplate.getForObject(
                "http://localhost:8081/author/" + book.getAuthorId(),
                String.class);

        return BookResponse.builder()
                .title(book.getTitle())
                .publicationDate(book.getPublicationDate())
                .authorFullName(authorFullName)
                .build();
    }
}
