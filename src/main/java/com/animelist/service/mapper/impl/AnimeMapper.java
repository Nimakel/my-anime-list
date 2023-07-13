package com.animelist.service.mapper.impl;

import com.animelist.dto.request.AnimeRequestDto;
import com.animelist.dto.response.AnimeResponseDto;
import com.animelist.model.Anime;
import com.animelist.model.Author;
import com.animelist.model.Studio;
import com.animelist.service.AuthorService;
import com.animelist.service.StudioService;
import com.animelist.service.mapper.MapperToDto;
import com.animelist.service.mapper.MapperToModel;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class AnimeMapper implements MapperToModel<AnimeRequestDto, Anime>,
        MapperToDto<Anime, AnimeResponseDto> {
    private final AuthorService authorService;
    private final StudioService studioService;

    @Override
    public AnimeResponseDto mapToDto(Anime anime) {
        AnimeResponseDto responseDto = new AnimeResponseDto();
        responseDto.setTitle(anime.getTitle());
        responseDto.setDescription(anime.getDescription());
        responseDto.setAuthorIds(anime.getAuthors().stream().map(Author::getId).toList());
        responseDto.setStudioIds(anime.getStudios().stream().map(Studio::getId).toList());
        responseDto.setId(anime.getId());
        return responseDto;
    }

    @Override
    public Anime mapToModel(AnimeRequestDto animeRequestDto) {
        Anime anime = new Anime();
        anime.setTitle(animeRequestDto.getTitle());
        anime.setDescription(animeRequestDto.getDescription());
        anime.setAuthors(getAuthors(animeRequestDto.getAuthorIds()));
        anime.setStudios(getStudios(animeRequestDto.getAuthorIds()));
        return anime;
    }

    private List<Author> getAuthors(List<Long> ids) {
        return ids.stream()
                .map(authorService::get)
                .collect(Collectors.toList());
    }

    private List<Studio> getStudios(List<Long> ids) {
        return ids.stream()
                .map(studioService::get)
                .collect(Collectors.toList());
    }
}
