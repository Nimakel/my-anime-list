package com.animelist.service;

import com.animelist.model.Author;
import java.util.Optional;

public interface AuthorService {
    Author add(Author author);

    Author get(Long id);

    Author update(Long id, Author author);

    void delete(Long id);
}
