package com.animelist.service;

import com.animelist.model.Anime;
import java.util.List;
import java.util.Optional;

public interface AnimeService {
    Anime add(Anime anime);

    Anime get(Long id);

    Anime update(Long id, Anime anime);

    void delete(Long id);

    List<Anime> findAllByStudioId(Long id);

    List<Anime> findAllByAuthorId(Long id);
}
