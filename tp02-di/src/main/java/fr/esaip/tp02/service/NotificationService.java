package fr.esaip.tp02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Exercice 1 - Injection par setter de MessageService.
 * Spring injecte automatiquement le bean correspondant au profil actif.
 */
@Component
public class NotificationService {

    private MessageService messageService;

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public String notify() {
        return "[NotificationService] impl=" + messageService.getClass().getSimpleName()
                + " -> " + messageService.getMessage();
    }
}
