package mk.ukim.finki.webprograming.service.impl;

import mk.ukim.finki.webprograming.model.Artist;
import mk.ukim.finki.webprograming.repository.jpa.ArtistRepository;
import mk.ukim.finki.webprograming.repository.jpa.SongRepository;
import mk.ukim.finki.webprograming.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
    public final ArtistRepository artistRepository;
    private final SongRepository songRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository, SongRepository songRepository) {
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findById(Long id) {
        return artistRepository.findById(id).orElse(null);

    }

}