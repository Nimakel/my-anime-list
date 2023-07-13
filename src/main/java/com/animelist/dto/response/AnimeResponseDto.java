package com.animelist.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class AnimeResponseDto {
    private Long id;
    private String title;
    private String description;
    private List<Long> authorIds;
    private List<Long> studioIds;
}
