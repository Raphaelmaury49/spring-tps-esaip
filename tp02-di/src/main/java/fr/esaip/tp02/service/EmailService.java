package fr.esaip.tp02.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Exercice 1 : bean par defaut grace a @Primary.
 * Exercice 2 : @Profile("default") => actif uniquement sans profil actif.
 *              Remplace par DevMessageService ou ProdMessageService selon profil.
 */
@Component
@Primary
@Profile("default")
public class EmailService implements MessageService {
    @Override
    public String getMessage() {
        return "Message envoye par email.";
    }
}
