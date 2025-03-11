package com.book.bookstore.libraryapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper.INSTANCE::toBookResponse)
                .collect(Collectors.toList());
    }

    public Book getBookById(long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    public Book addBook(BookDTO bookDTO) throws Exception {
        Book book = BookMapper.INSTANCE.toBook(bookDTO);
        Optional<Author> author = authorRepository.findById(bookDTO.getAuthorId());
        if (author.isEmpty()) {
            throw new ResouceNotFoundException("Author not found");
        }
        book.setAuthor(author.get());
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }
}
