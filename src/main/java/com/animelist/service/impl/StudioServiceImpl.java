package com.animelist.service.impl;

import com.animelist.model.Studio;
import com.animelist.repository.StudioRepository;
import com.animelist.service.StudioService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudioServiceImpl implements StudioService {
    private final StudioRepository studioRepository;

    @Override
    public Studio add(Studio studio) {
        return studioRepository.save(studio);
    }

    @Override
    public Studio get(Long id) {
        return studioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Can't get Studio from DB by ID: " + id));
    }

    @Override
    public Studio update(Long id, Studio studio) {
        Studio reference = studioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Can't get Studio from DB for update by ID: " + id));
        reference.setStudioName(studio.getStudioName());
        return reference;
    }

    @Override
    public void delete(Long id) {
        studioRepository.deleteById(id);
    }
}
