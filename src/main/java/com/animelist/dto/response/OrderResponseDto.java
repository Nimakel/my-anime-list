package com.animelist.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderResponseDto {
    private Long id;
    private Long animeId;
    private Integer mark;
    private Integer list;
    private LocalDateTime changesDate;
}
