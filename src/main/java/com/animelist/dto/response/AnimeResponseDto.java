package com.animelist.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class AnimeResponseDto {
    private Long id;
    private String title;
    private String description;
    private List<Long> authorIds;
    private List<Long> studioIds;
}
