package com.animelist.service.mapper.impl;

import com.animelist.dto.request.StudioRequestDto;
import com.animelist.model.Studio;
import com.animelist.service.mapper.MapperToModel;
import org.springframework.stereotype.Component;

@Component
public class StudioMapper implements MapperToModel<StudioRequestDto, Studio> {
    @Override
    public Studio mapToModel(StudioRequestDto studioRequestDto) {
        Studio studio = new Studio();
        studio.setStudioName(studio.getStudioName());
        return studio;
    }
}
