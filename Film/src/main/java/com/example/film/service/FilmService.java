package com.example.film.service;

import com.example.film.model.FilmEntity;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    List<FilmEntity> findallfilm();
    Optional<FilmEntity> findById(Long id);
    FilmEntity savefilm(FilmEntity filmEntity);
    FilmEntity updateFilm(Long id, FilmEntity filmEntity);
    String deleteFilm(Long id);
}
