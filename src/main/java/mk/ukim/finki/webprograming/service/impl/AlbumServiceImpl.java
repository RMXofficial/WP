package mk.ukim.finki.webprograming.service.impl;

import mk.ukim.finki.webprograming.model.Album;
import mk.ukim.finki.webprograming.repository.jpa.AlbumRepository;
import mk.ukim.finki.webprograming.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album findOne(Long id) {
        return albumRepository.findOneById(id).orElse(null);
    }
}