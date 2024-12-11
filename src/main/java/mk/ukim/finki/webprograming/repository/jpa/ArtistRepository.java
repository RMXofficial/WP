package mk.ukim.finki.webprograming.repository.jpa;

import mk.ukim.finki.webprograming.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findById(Long Id);

    List<Artist> findAll();


}
