package mk.ukim.finki.webprograming.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String ballonColor;
    private String baloonSize;
    private String clientName;
    private String clientAddress;
    private Long orderId;
}
