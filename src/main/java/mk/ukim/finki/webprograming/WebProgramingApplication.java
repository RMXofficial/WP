package mk.ukim.finki.webprograming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class WebProgramingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebProgramingApplication.class, args);
    }

}
