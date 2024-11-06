package mk.ukim.finki.webprograming.service;

import mk.ukim.finki.webprograming.model.Order;

public interface OrderService{
    Order placeOrder(String balloonColor, String clientName, String address);
}
