package mk.ukim.finki.webprograming.service.impl;

import mk.ukim.finki.webprograming.model.Artist;
import mk.ukim.finki.webprograming.model.Song;
import mk.ukim.finki.webprograming.repository.jpa.AlbumRepository;
import mk.ukim.finki.webprograming.repository.jpa.SongRepository;
import mk.ukim.finki.webprograming.service.SongService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
    public final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    public SongServiceImpl(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        Optional<Song> optionalSong = songRepository.findById(song.getId());
        if (optionalSong.isPresent()) {
            Song newSong = optionalSong.get();
            List<Artist> artists = newSong.getPerformers();
            artists.add(artist);
            newSong.setPerformers(artists);
        }

        return artist;
    }

    @Override
    public Optional<Song> findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }

    @Override
    public void saveSongFull(Song song, Long albumId) {
        albumRepository.findById(albumId).ifPresent(song::setAlbum);
        songRepository.save(song);
    }

    @Override
    public Optional<Song> findById(Long songId) {
        return songRepository.findById(songId);
    }

    @Override
    public void deleteSongById(Long songId) {
        songRepository.deleteById(songId);
    }

    @Override
    public void saveSong(String trackId, String title, String genre, int releaseYear, Long songId, Long albumId) {
        Song song = new Song(trackId, title, genre, releaseYear, new ArrayList<>());
        if (albumId != null) {
            song.setAlbum(albumRepository.findById(albumId).get());
        }
        if (songId != null) {
            song.setId(songId);
        }
        songRepository.save(song);
    }

    @Override
    public List<Song> findByAlbumId(String albumId) {
        return songRepository.findAllByAlbum_Id(Long.valueOf(albumId));

    }
}