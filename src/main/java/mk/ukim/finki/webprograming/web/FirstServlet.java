package mk.ukim.finki.webprograming.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/home")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer=resp.getWriter();
        String name=req.getParameter("name");
        String surname=req.getParameter("surname");
        if (name==null||surname==null){
            name="name";
            surname="surname";
        }
        writer.println(String.format("<html><head></head><body><h1>%s %s</h1></body></html>",name,surname));
    }
}
