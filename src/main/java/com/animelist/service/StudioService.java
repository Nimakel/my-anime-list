package com.animelist.service;

import com.animelist.model.Studio;
import java.util.Optional;

public interface StudioService {
    Studio add(Studio studio);

    Studio get(Long id);

    Studio update(Long id, Studio studio);

    void delete(Long id);
}
