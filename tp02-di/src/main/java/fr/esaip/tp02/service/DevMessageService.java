package fr.esaip.tp02.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/** Exercice 2 - Actif UNIQUEMENT avec spring.profiles.active=dev */
@Component
@Profile("dev")
public class DevMessageService implements MessageService {
    @Override
    public String getMessage() {
        return "[DEV] Message envoye depuis l'environnement de DEVELOPPEMENT.";
    }
}
