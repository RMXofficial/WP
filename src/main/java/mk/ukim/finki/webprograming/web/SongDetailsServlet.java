package mk.ukim.finki.webprograming.web;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import mk.ukim.finki.webprograming.model.Artist;
import mk.ukim.finki.webprograming.model.Song;
import mk.ukim.finki.webprograming.service.SongService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/songDetails")
public class SongDetailsServlet extends HttpServlet {
    public final SongService songService;
    public final TemplateEngine springTemplateEngine;

    public SongDetailsServlet(SongService songService, TemplateEngine templateEngine) {
        this.songService = songService;
        this.springTemplateEngine = templateEngine;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        String trackId = req.getParameter("trackId");
        resp.setContentType("text/html;charset=UTF-8");
        Song song = songService.findByTrackId(trackId).orElse(null);
        List<Artist> artists = new ArrayList<>();
        if (song != null) {
            artists = song.getPerformers();
        } else {
            resp.sendRedirect("/songs");
        }


        WebContext context = new WebContext(webExchange);
        context.setVariable("song", song);
        context.setVariable("artists", artists);
        springTemplateEngine.process("songDetails.html", context, resp.getWriter());

    }
}