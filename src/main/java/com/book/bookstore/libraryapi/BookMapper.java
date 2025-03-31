package com.book.bookstore.libraryapi;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toBook(BookDTO bookDTO);

    @Mapping(target = "authorFullName", source = "author.lastName")
//    @Mapping(target = "publicationDate", source = "publicationDate")
//    @Mapping(target = "authorFullName", expression = "java(book.getAuthor().getFirstName() + \" \" + book.getAuthor().getLastName())")
    BookResponse toBookResponse(Book book);
}
