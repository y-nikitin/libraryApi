package com.library.microLib.author.controller;

import com.library.microLib.author.service.AuthorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorController {

    AuthorService authorService;

    @GetMapping("/{id}")
    public String getAuthorFullName(@PathVariable("id") Long id) {
        return authorService.getAuthorFullNameById(id);
    }
}
