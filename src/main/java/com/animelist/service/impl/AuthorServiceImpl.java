package com.animelist.service.impl;

import com.animelist.model.Author;
import com.animelist.repository.AuthorRepository;
import com.animelist.service.AuthorService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public Author add(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author get(Long id) {
        return authorRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Can't get Author from DB by ID: " + id));
    }

    @Override
    public Author update(Long id, Author author) {
        Author reference = authorRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Can't get Author from DB for update by ID: " + id));
        reference.setName(author.getName());
        return reference;
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
