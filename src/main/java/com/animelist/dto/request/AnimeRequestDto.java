package com.animelist.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class AnimeRequestDto {
    private String title;
    private String description;
    private List<Long> authorIds;
    private List<Long> studioIds;
}
