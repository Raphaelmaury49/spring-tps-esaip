package fr.esaip.tp02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TP02 - Injection de Dependances Spring Boot
 *
 * Exercice 1 : @Component / @Autowired / @Primary   -> GET /notification
 * Exercice 2 : @Profile dev/prod                    -> GET /notification
 * Exercice 3 : dependance circulaire resolue @Lazy  -> logs au demarrage
 * TP avance  : BavardService + @PostConstruct        -> GET /hello, GET /blabla
 */
@SpringBootApplication
public class Tp02Application {
    public static void main(String[] args) {
        SpringApplication.run(Tp02Application.class, args);
    }
}
