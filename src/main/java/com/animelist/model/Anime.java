package com.animelist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "animes")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "anime_title")
    private String title;
    @Column(name = "anime_description")
    private String description;
    @ManyToMany
    @JoinTable(name = "authors_animes",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;
    @ManyToMany
    @JoinTable(name = "studios_animes",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "studio_id"))
    private List<Studio> studios;

    @Override
    public String toString() {
        return "Anime{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", description='" + description + '\''
                + ", authors=" + authors
                + ", studios=" + studios
                + '}';
    }
}
