package mk.ukim.finki.webprograming.repository;

import mk.ukim.finki.webprograming.bootstrap.DataHolder;
import mk.ukim.finki.webprograming.model.Album;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class AlbumRepository {
    public List<Album> findAll() {
        return DataHolder.albums;
    }

    public Optional<Album> findOne(Long id) {
        return DataHolder.albums.stream().filter(album -> album.getId().equals(id)).findFirst();
    }
}