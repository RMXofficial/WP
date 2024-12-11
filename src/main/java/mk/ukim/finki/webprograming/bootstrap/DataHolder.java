package mk.ukim.finki.webprograming.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.webprograming.model.*;
import mk.ukim.finki.webprograming.repository.jpa.AlbumRepository;
import mk.ukim.finki.webprograming.repository.jpa.ArtistRepository;
import mk.ukim.finki.webprograming.repository.jpa.SongRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events = null;
    public static List<EventBooking> eventBookings = null;

    public static List<Artist> artists = new ArrayList<>();
    public static List<Song> songs = new ArrayList<>();
    public static List<Album> albums = new ArrayList<>();

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;

    public DataHolder(AlbumRepository albumRepository, ArtistRepository artistRepository, SongRepository songRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    @PostConstruct
    public void init() {

        for (int i = 0; i < 6; i++) {
            albums.add(new Album(String.format("Album%d", i), String.format("Genre%d", i), String.format("200%d", i)));
        }
        if (this.albumRepository.count() == 0) this.albumRepository.saveAll(albums);

        artists = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            artists.add(new Artist(String.format("ArtistName%d", i), String.format("ArtistLastName%d", i), String.format("Bio%d", i)));
        }
        artists.add(new Artist("BORIS", "GOSEVSKI", "BG Bio"));
        this.artistRepository.saveAll(artists);

        songs = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Song newSong = new Song(String.valueOf(i), String.format("Title%d", i), String.format("Genre%d", i), 2000 + i, new ArrayList<>());
            newSong.setAlbum(albums.get(i - 1));
            songs.add(newSong);
        }
        this.songRepository.saveAll(songs);

        // TODO ADD THIS FOR EVENTS
        events = new ArrayList<>();
        events.add(new Event("Concert", "An evening of live music", 95));
        events.add(new Event("Workshop", "Interactive tech workshop", 85));
        events.add(new Event("Art Exhibition", "Showcase of local artists", 75));
        events.add(new Event("Film Festival", "Annual indie film festival", 90));
        events.add(new Event("Food Fair", "Taste dishes from around the world", 88));
        events.add(new Event("Book Fair", "Meet authors and buy books", 80));
        events.add(new Event("Science Conference", "Latest research presentations", 70));
        events.add(new Event("Charity Run", "Run to support a cause", 65));
        events.add(new Event("Theater Play", "Drama play by local actors", 78));
        events.add(new Event("New Year's Eve Party", "Celebrate with live music and fireworks", 98));
        eventBookings = new ArrayList<>();
    }
}
