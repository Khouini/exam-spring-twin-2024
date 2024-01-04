package khouini.yacine.examenspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExamenSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenSpringApplication.class, args);
    }

}
