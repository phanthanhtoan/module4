package com.codegym.service.Impl;

import com.codegym.model.Music;
import com.codegym.repository.MusicRepository;
import com.codegym.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Music findById(Long id) {
        return musicRepository.findById(id);
    }

    @Override
    public void save(Music customer) {
        musicRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        musicRepository.remove(id);
    }
}
