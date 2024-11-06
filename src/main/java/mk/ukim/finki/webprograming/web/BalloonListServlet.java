package mk.ukim.finki.webprograming.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import mk.ukim.finki.webprograming.model.Balloon;
import mk.ukim.finki.webprograming.service.BalloonService;
import mk.ukim.finki.webprograming.service.impl.BalloonServiceImpl;

import java.io.IOException;
import java.util.List;

@Data
@AllArgsConstructor
@WebServlet(urlPatterns = "/home123")
public class BalloonListServlet extends HttpServlet {
    private final BalloonService balloonService=new BalloonServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("balloons", balloonService.listAll());
        req.getRequestDispatcher("/WEB-INF/templates/listBalloons.html").forward(req, resp);
    }
}
