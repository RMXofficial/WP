package mk.ukim.finki.webprograming.repository.jpa;

import mk.ukim.finki.webprograming.bootstrap.DataHolder;
import mk.ukim.finki.webprograming.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    public List<Album> findAll();

    public Optional<Album> findOneById(Long id);
}
