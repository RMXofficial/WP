package mk.ukim.finki.webprograming.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.webprograming.model.Event;
import mk.ukim.finki.webprograming.model.EventBooking;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events=null;
    public static List<EventBooking> eventBookings=null;

    @PostConstruct
    public void init() {
        events=new ArrayList<>();
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
        eventBookings=new ArrayList<>();
    }
}
