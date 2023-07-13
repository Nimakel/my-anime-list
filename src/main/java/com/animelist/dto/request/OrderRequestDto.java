package com.animelist.dto.request;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OrderRequestDto {
    private Long animeId;
    private Integer mark;
    private Integer list;
    private LocalDateTime changesDate;
}
