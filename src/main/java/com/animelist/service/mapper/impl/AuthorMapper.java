package com.animelist.service.mapper.impl;

import com.animelist.dto.request.AuthorRequestDto;
import com.animelist.model.Author;
import com.animelist.service.mapper.MapperToModel;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements MapperToModel<AuthorRequestDto, Author> {
    @Override
    public Author mapToModel(AuthorRequestDto authorRequestDto) {
        Author author = new Author();
        author.setName(authorRequestDto.getName());
        return author;
    }
}
