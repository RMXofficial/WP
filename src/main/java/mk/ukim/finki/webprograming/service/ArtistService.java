package mk.ukim.finki.webprograming.service;

import mk.ukim.finki.webprograming.model.Artist;
import mk.ukim.finki.webprograming.model.Song;

import java.util.List;

public interface ArtistService{
    List<Artist> listArtists();
    Artist findById(Long id);
}