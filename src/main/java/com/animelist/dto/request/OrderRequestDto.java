package com.animelist.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderRequestDto {
    private Long animeId;
    private Integer mark;
    private Integer list;
    private LocalDateTime changesDate;
}
