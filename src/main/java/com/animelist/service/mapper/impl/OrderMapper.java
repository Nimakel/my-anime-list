package com.animelist.service.mapper.impl;

import com.animelist.dto.request.OrderRequestDto;
import com.animelist.model.Order;
import com.animelist.service.AnimeService;
import com.animelist.service.mapper.MapperToModel;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OrderMapper implements MapperToModel<OrderRequestDto, Order> {
    private final AnimeService animeService;

    @Override
    public Order mapToModel(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setAnime(animeService.get(orderRequestDto.getAnimeId()));
        order.setChangesDate(LocalDateTime.now());
        order.setMark(order.getMark());
        order.setList(order.getList());
        return order;
    }
}
