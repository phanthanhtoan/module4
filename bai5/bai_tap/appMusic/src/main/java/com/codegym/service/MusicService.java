package com.codegym.service;

import com.codegym.model.Music;

import java.util.List;

public interface MusicService {
    List<Music> findAll();

    Music findById(Long id);

    void save(Music music);

    void remove(Long id);
}
