package mk.ukim.finki.webprograming.service.impl;

import mk.ukim.finki.webprograming.model.Balloon;
import mk.ukim.finki.webprograming.repository.BalloonRepository;
import mk.ukim.finki.webprograming.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalloonServiceImpl implements BalloonService {

    private final BalloonRepository balloonRepository=new BalloonRepository();

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text);
    }
}
