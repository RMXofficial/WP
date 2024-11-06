package mk.ukim.finki.webprograming.repository;

import mk.ukim.finki.webprograming.model.Balloon;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class BalloonRepository {
    private List<Balloon> balloons=new ArrayList<>();

    public BalloonRepository() {
        balloons.add(new Balloon("Red","Red balloon"));
        balloons.add(new Balloon("Green","Green balloon"));
        balloons.add(new Balloon("Blue","Blue balloon"));
        balloons.add(new Balloon("Yellow","Yellow balloon"));
        balloons.add(new Balloon("Orange","Orange balloon"));
        balloons.add(new Balloon("Pink","Pink balloon"));
        balloons.add(new Balloon("Gray","Gray balloon"));
        balloons.add(new Balloon("White","White balloon"));
        balloons.add(new Balloon("Black","Black balloon"));
        balloons.add(new Balloon("Cyan","Cyan balloon"));
    }
    public List<Balloon> findAllBalloons() {
        return balloons;
    }

    public List<Balloon> findAllByNameOrDescription(String text) {
        return balloons.stream().filter(balloon -> balloon.getName().toLowerCase().contains(text.toLowerCase()) ||
                balloon.getDescription().toLowerCase().contains(text.toLowerCase())).collect(Collectors.toList());
    }
}
