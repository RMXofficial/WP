package mk.ukim.finki.webprograming.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/confirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("balloonColor") == null) {
            resp.sendRedirect("/"); // Redirect to the color selection page
            return;
        }
        String clientName = (String) session.getAttribute("clientName");
        String clientAddress = (String) session.getAttribute("clientAddress");
        String balloonColor = (String) session.getAttribute("balloonColor");
        String balloonSize = (String) session.getAttribute("balloonSize");

//        String clientIP=req.getRemoteAddr();
//        String clientBrowser=req.getHeader("User-Agent");
        req.setAttribute("clientName", clientName);
        req.setAttribute("clientAddress", clientAddress);
        req.setAttribute("balloonColor", balloonColor);
        req.setAttribute("balloonSize", balloonSize);
//        req.setAttribute("clientIP", clientIP);
//        req.setAttribute("clientBrowser", clientBrowser);
        req.getRequestDispatcher("/templates/confirmationInfo.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        resp.sendRedirect("/");
    }
}
