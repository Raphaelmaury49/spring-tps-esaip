package fr.esaip.tp02.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

/**
 * TP avance - BavardService
 * @Service = @Component avec semantique metier.
 * @PostConstruct : appelee apres injection, avant le premier appel HTTP.
 */
@Service
public class BavardService {

    private String nom = "Raphael";

    @PostConstruct
    private void postConstruct() {
        System.out.println("[PostConstruct] BavardService initialise - nom='" + nom + "'");
        System.out.println("[PostConstruct] Classe : " + this.getClass().getSimpleName());
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String parler() {
        return "Je m'appelle '" + nom + "' et je suis un '" + this.getClass().getSimpleName() + "'";
    }
}
