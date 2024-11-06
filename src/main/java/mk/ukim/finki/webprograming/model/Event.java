package mk.ukim.finki.webprograming.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private String name;
    private String description;
    private double popularityScore;
}
