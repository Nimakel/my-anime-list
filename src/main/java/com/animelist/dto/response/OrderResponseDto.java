package com.animelist.dto.response;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Long id;
    private Long animeId;
    private Integer mark;
    private Integer list;
    private LocalDateTime changesDate;
}
