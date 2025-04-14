package com.library.microLib.author.service;

import com.library.microLib.author.model.Author;
import com.library.microLib.author.repository.AuthorRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorService {

    AuthorRepository authorRepository;

    public String getAuthorFullNameById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow();
        return String.join(" ", author.getFirstName(), author.getLastName());
    }
}
