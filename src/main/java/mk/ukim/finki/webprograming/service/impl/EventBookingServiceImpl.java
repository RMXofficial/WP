package mk.ukim.finki.webprograming.service.impl;

import mk.ukim.finki.webprograming.model.EventBooking;
import mk.ukim.finki.webprograming.repository.EventRepository;
import mk.ukim.finki.webprograming.service.EventBookingService;
import org.springframework.stereotype.Service;

@Service
public class EventBookingServiceImpl implements EventBookingService {
    private final EventRepository eventRepository;
    public EventBookingServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets) {
        return new EventBooking(eventName, attendeeName, attendeeAddress, numberOfTickets);
    }
}
