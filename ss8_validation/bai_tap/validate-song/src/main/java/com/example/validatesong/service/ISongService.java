package com.example.validatesong.service;

import com.example.validatesong.model.Song;

import java.util.List;

public interface ISongService {

    List<Song> findAllSong();

    void addSong(Song song);

    Song findById(Integer id);

    void editSong( Integer id, Song song);


}
