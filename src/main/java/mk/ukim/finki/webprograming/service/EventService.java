package mk.ukim.finki.webprograming.service;

import mk.ukim.finki.webprograming.model.Event;

import java.util.List;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text,int rating);
}