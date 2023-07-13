package com.animelist.service.mapper;

/**
 *
 * @param <RequestDto> - request dto model
 * @param <Model> - model of entity
 */

public interface MapperToModel<RequestDto, Model> {
    Model mapToModel(RequestDto dto);
}
