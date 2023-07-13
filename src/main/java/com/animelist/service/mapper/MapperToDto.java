package com.animelist.service.mapper;

/**
 *
 * @param <Model> - model of entity
 * @param <ResponseDto> - response dto model
 */

public interface MapperToDto<Model, ResponseDto> {
    ResponseDto mapToDto(Model model);
}
