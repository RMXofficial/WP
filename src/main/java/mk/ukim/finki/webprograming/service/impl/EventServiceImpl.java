package mk.ukim.finki.webprograming.service.impl;

import mk.ukim.finki.webprograming.model.Event;
import mk.ukim.finki.webprograming.repository.EventRepository;
import mk.ukim.finki.webprograming.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text,int rating) {
        return eventRepository.searchEvents(text,rating);
    }
}
