package mk.ukim.finki.webprograming.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/active-sessions")
public class ActiveSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int activeSessions = SessionCounterListener.getActiveSessions();
        resp.getWriter().println("<html><body>");
        resp.getWriter().println("<p>number of active sessions: "+ activeSessions+"</p>");
        resp.getWriter().println("</body></html>");
    }
}
