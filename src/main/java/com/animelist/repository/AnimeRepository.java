package com.animelist.repository;

import com.animelist.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {
    @Query("SELECT a FROM Anime a LEFT JOIN a.authors aa WHERE aa.id = :id")
    List<Anime> findAllByAuthorId(Long id);
    @Query("SELECT a FROM Anime a LEFT JOIN a.studios ast WHERE ast.id = :id")
    List<Anime> findAllByStudioId(Long id);
}
