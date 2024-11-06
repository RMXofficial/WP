package mk.ukim.finki.webprograming.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/selectBalloonSize")
public class SelectBalloonSizeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String balloonColor = req.getParameter("color");
        session.setAttribute("balloonColor", balloonColor);
        resp.sendRedirect("/selectBalloonSize");
    }
}
