package mk.ukim.finki.webprograming.repository;

import mk.ukim.finki.webprograming.bootstrap.DataHolder;
import mk.ukim.finki.webprograming.model.Event;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EventRepository {
    public List<Event> findAll() {
        return DataHolder.events;
    }
    public List<Event> searchEvents(String text,int rating){
        return DataHolder.events.stream()
                .filter(event -> (event.getName().contains(text) ||
                        event.getDescription().contains(text)) &&
                        event.getPopularityScore() >= rating)
                .toList();
    }

}
