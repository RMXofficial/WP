package mk.ukim.finki.webprograming.repository.jpa;

import mk.ukim.finki.webprograming.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findAll();

//     Artist addArtistToSong(Artist artist, Song song);

    List<Song> findAllByAlbum_Id(Long albumId);

    Optional<Song> findOneById(Long Id);

    Optional<Song> findByTrackId(String trackId);
}
