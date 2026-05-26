package fr.esaip.tp02.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/** Exercice 1 - Implementation SMS, active sur profil default (non selectionne par @Primary) */
@Component
@Profile("default")
public class SmsService implements MessageService {
    @Override
    public String getMessage() {
        return "Message envoye par SMS.";
    }
}
