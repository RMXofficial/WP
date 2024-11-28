package mk.ukim.finki.webprograming.repository;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.webprograming.bootstrap.DataHolder;
import mk.ukim.finki.webprograming.model.Album;
import mk.ukim.finki.webprograming.model.Artist;
import mk.ukim.finki.webprograming.model.Song;
import mk.ukim.finki.webprograming.service.AlbumService;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository {


    private final AlbumService albumService;

    public SongRepository(AlbumService albumService) {
        this.albumService = albumService;
    }

    public List<Song> findAll() {
        return DataHolder.songs;
    }

    public Optional<Song> findByTrackId(String trackId) {
        return DataHolder.songs.stream().filter(song -> song.getTrackId().equals(trackId)).findFirst();
    }

//    public Artist addArtistToSong(Artist artist, Song song) {
//        DataHolder.songs.stream().filter(tempSong -> tempSong.equals(song)).forEach(tempSong -> {
//            List<Artist> currentPerformers = tempSong.getPerformers();
//            currentPerformers.add(artist);
//            tempSong.setPerformers(currentPerformers);
//        });
//        return artist;
//    }
public Artist addArtistToSong(Artist artist, Song song) {
    DataHolder.songs.stream().filter(tempSong -> tempSong.equals(song)).forEach(tempSong -> {
        List<Artist> currentPerformers = tempSong.getPerformers();
        if (currentPerformers.size() < 2) {
            currentPerformers.add(artist);
            tempSong.setPerformers(currentPerformers);
        }
        else {
            throw new IllegalStateException("A song can only have a maximum of 2 artists.");
        }
    });
    return artist;
}

    public void saveSong(Song song, Long albumId) {
        DataHolder.songs.removeIf(song1 -> song1.getId().equals(song.getId()));
        Album album = albumService.findOne(albumId);
        song.setAlbum(album);
        DataHolder.songs.add(song);

    }

    public Optional<Song> findById(Long songId) {

        return DataHolder.songs.stream().filter(song -> song.getId().equals(songId)).findFirst();
    }

    public void deleteSongById(Long songId) {
        DataHolder.songs.removeIf(song -> song.getId().equals(songId));
    }
}