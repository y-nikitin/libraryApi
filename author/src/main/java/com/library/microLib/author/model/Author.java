package com.library.microLib.author.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "author")
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
