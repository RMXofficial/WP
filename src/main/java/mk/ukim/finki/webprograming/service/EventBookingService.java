package mk.ukim.finki.webprograming.service;

import mk.ukim.finki.webprograming.model.EventBooking;

public interface EventBookingService{
    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets);
}