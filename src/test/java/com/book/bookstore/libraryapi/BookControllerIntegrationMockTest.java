package com.book.bookstore.libraryapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@Rollback
@ActiveProfiles("test")
public class BookControllerIntegrationMockTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllBooks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testAddBookValidationFailed() throws Exception {
        BookDTO bookDTO = new BookDTO(null, LocalDate.now(), 300, 300, 1L);

        mockMvc.perform(MockMvcRequestBuilders.post("/book")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookDTO)))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
    }

    @Test
    void testUpdateBookSuccess() throws Exception {

        Author author = Author.builder()
                .firstName("John")
                .lastName("Doe")
                .birthDate(LocalDate.of(1980, 4, 10))
                .build();

        Book book = Book.builder()
                .title("TestBook")
                .price(100)
                .pages(300)
                .publicationDate(LocalDate.of(1970, 3, 20))
                .author(author)
                .build();

        Book insertedBook = bookRepository.save(book);

        insertedBook.setTitle("UpdatedTitle");

        mockMvc.perform(MockMvcRequestBuilders.put("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(insertedBook)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("UpdatedTitle")));
    }

    @Test
    void testDeleteBookSuccess() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/book/{id}", 702L))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/book/{id}", 702L))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
