package mk.ukim.finki.webprograming.repository;
import mk.ukim.finki.webprograming.bootstrap.DataHolder;
import mk.ukim.finki.webprograming.model.Album;
import mk.ukim.finki.webprograming.model.Artist;
import mk.ukim.finki.webprograming.model.Song;
import org.springframework.stereotype.Repository;
import mk.ukim.finki.webprograming.service.AlbumService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class ArtistRepository {
    public List<Artist> findAll() {
        return DataHolder.artists;
    }
    public Optional<Artist> findById(Long id){
        return DataHolder.artists.stream().filter(artist -> artist.getId().equals(id)).findFirst();
    }
    public void deleteArtistById(Long artistId) {
        DataHolder.artists.removeIf(artist -> artist.getId().equals(artistId));
    }
    public void saveArtist(Artist artist) {
        DataHolder.artists.removeIf(artist1 -> artist1.getId().equals(artist.getId()));
        DataHolder.artists.add(artist);
    }
}