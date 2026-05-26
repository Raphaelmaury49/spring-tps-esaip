package fr.esaip.tp02.controller;

import fr.esaip.tp02.circular.ClassA;
import fr.esaip.tp02.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exercice 1 & 2 - Demonstration NotificationService
 * GET /notification -> message selon profil actif
 * GET /circular     -> demo dependance circulaire resolue par @Lazy
 */
@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private ClassA classA;

    /**
     * Sans profil   -> EmailService (@Primary)
     * Profil dev    -> DevMessageService
     * Profil prod   -> ProdMessageService
     */
    @GetMapping("/notification")
    public String notification() {
        return notificationService.notify();
    }

    /** Exercice 3 : appel de ClassA -> ClassB (cycle resolu par @Lazy) */
    @GetMapping("/circular")
    public String circular() {
        return classA.direBonjour();
    }
}
