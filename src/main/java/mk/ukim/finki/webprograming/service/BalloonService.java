package mk.ukim.finki.webprograming.service;

import mk.ukim.finki.webprograming.model.Balloon;

import java.util.List;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
}