package mk.ukim.finki.webprograming.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.WebConnection;
import mk.ukim.finki.webprograming.model.EventBooking;
import mk.ukim.finki.webprograming.service.EventBookingService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

import static java.lang.Long.parseLong;

@WebServlet(urlPatterns = "/eventBooking")
public class EventBookingServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    EventBookingService eventBookingService;

    public EventBookingServlet(SpringTemplateEngine springTemplateEngine,EventBookingService eventBookingService) {
        this.springTemplateEngine = springTemplateEngine;
        this.eventBookingService = eventBookingService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange= JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext webContext=new WebContext(webExchange);
        springTemplateEngine.process("bookingConfirmation.html", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EventBooking eventBooking=eventBookingService.placeBooking(
                req.getParameter("eventBook"),
                req.getServerName(),
                req.getLocalAddr(),
                parseLong(req.getParameter("numTickets"))
        );
        req.getSession().setAttribute("eventBooking", eventBooking);
        resp.sendRedirect( "/eventBooking");
    }
}
