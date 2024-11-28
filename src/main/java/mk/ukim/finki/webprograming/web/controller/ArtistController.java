package mk.ukim.finki.webprograming.web.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.webprograming.model.Artist;
import mk.ukim.finki.webprograming.service.ArtistService;
import mk.ukim.finki.webprograming.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/artist")
public class ArtistController {
    public final ArtistService artistService;
    public final SongService songService;

    public ArtistController(TemplateEngine springTemplateEngine, ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

    @GetMapping("")
    protected String getArtists(@RequestParam String trackId, Model model) throws ServletException, IOException {
        Long trackIdLong = Long.parseLong(trackId);
        model.addAttribute("trackId", trackIdLong);
        model.addAttribute("artists", artistService.listArtists());
        return "artistList.html";
    }

    @PostMapping("")
    protected String doPost(@RequestParam String trackId, @RequestParam String artistId, Model model) throws ServletException, IOException {
        try {
            Artist artist = artistService.findById(Long.parseLong(artistId));
            songService.findByTrackId(trackId).ifPresent(song -> songService.addArtistToSong(artist, song));
            return "redirect:/songDetails?trackId=" + trackId;
        } catch (IllegalStateException e) {
            model.addAttribute("error", e.getMessage());
            return "songDetails";
        }
    }
//    @PostMapping("")
//    protected String doPost(@RequestParam String trackId, @RequestParam String artistId, Model model) throws ServletException, IOException {
//        Artist artist = artistService.findById(Long.parseLong(artistId));
//
//        songService.findByTrackId(trackId).ifPresent(song -> {
//            if (song.getArtists().size() < 2) {
//                songService.addArtistToSong(artist, song);
//            } else {
//                model.addAttribute("error", "A song can only have a maximum of 2 artists.");
//            }
//        });
//        return "redirect:/songDetails?trackId=" + trackId;
//    }
@GetMapping("/edit/{artistId}")
public String editArtist(@PathVariable Long artistId, Model model) {
    Artist currentArtist = artistService.findById(artistId);

    model.addAttribute("artist", currentArtist);

    return "editArtist.html";
}
    @PostMapping("/edit")
    public String editArtist(@RequestParam Long artistId,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String bio,
                             Model model) {
        Artist artist = new Artist(artistId, firstName, lastName, bio);

        artistService.saveArtist(artist);

        return "redirect:/artist";
    }

    @PostMapping("/delete/{artistId}")
    public String deleteArtist(@PathVariable Long artistId, Model model) {
        artistService.deleteArtistById(artistId);
        return "redirect:/artist";
    }

}