package com.animelist.service.impl;

import com.animelist.model.Anime;
import com.animelist.repository.AnimeRepository;
import com.animelist.service.AnimeService;
import org.springframework.stereotype.Service;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AnimeServiceImpl implements AnimeService {
    private final AnimeRepository animeRepository;

    @Override
    public Anime add(Anime anime) {
        return animeRepository.save(anime);
    }

    @Override
    public Anime get(Long id) {
        return animeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Can't get Anime from DB by ID: " + id));
    }

    @Override
    public Anime update(Long id, Anime anime) {
        Anime reference = animeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Can't get Anime from DB for update by ID: " + id));
        reference.setTitle(anime.getTitle());
        reference.setDescription(anime.getDescription());
        reference.setStudios(anime.getStudios());
        reference.setAuthors(anime.getAuthors());
        return animeRepository.save(reference);
    }

    @Override
    public void delete(Long id) {
        animeRepository.deleteById(id);
    }

    @Override
    public List<Anime> findAllByStudioId(Long id) {
        return animeRepository.findAllByStudioId(id);
    }

    @Override
    public List<Anime> findAllByAuthorId(Long id) {
        return animeRepository.findAllByAuthorId(id);
    }
}
