package com.toad.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;


@Entity // This tells Hibernate to make a table out of this class
public class FilmDirector {
    @Id
    @Column(name = "film_id")
    private Integer filmId; // BIGINT

    @Column(name = "director_id")
    private Integer directorId;

    public Integer getFilmId() {
        return filmId;
    }

    public Integer getDirectorId() {
        return directorId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }
}
