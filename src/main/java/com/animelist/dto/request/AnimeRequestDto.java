package com.animelist.dto.request;

import java.util.List;
import lombok.Data;

@Data
public class AnimeRequestDto {
    private String title;
    private String description;
    private List<Long> authorIds;
    private List<Long> studioIds;
}
