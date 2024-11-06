package mk.ukim.finki.webprograming.service.impl;

import mk.ukim.finki.webprograming.model.Order;
import mk.ukim.finki.webprograming.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderServiceImpl implements OrderService {
    private static final AtomicLong ORDER_ID_GENERATOR = new AtomicLong();

    @Override
    public Order placeOrder(String balloonColor, String clientName, String address) {
        Long orderID=ORDER_ID_GENERATOR.incrementAndGet();
        return new Order(balloonColor,null,clientName,address,orderID);
    }
}
