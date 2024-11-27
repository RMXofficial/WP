package mk.ukim.finki.webprograming.service;

import mk.ukim.finki.webprograming.model.Album;

import java.util.List;

public interface AlbumService {
    public List<Album> findAll();
    public Album findOne(Long id);
}