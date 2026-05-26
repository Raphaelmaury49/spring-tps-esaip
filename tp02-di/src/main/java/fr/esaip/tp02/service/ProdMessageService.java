package fr.esaip.tp02.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/** Exercice 2 - Actif UNIQUEMENT avec spring.profiles.active=prod */
@Component
@Profile("prod")
public class ProdMessageService implements MessageService {
    @Override
    public String getMessage() {
        return "[PROD] Message envoye depuis l'environnement de PRODUCTION.";
    }
}
