package fr.esaip.tp02.controller;

import fr.esaip.tp02.service.BavardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TP avance - Demo injection BavardService + @PostConstruct
 * GET /hello  -> message simple avec le nom du BavardService
 * GET /blabla -> retourne BavardService.parler()
 */
@RestController
public class HelloController {

    @Autowired
    private BavardService bavardService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World ! (BavardService.nom = '" + bavardService.getNom() + "')";
    }

    @GetMapping("/blabla")
    public String blabla() {
        return bavardService.parler();
    }
}
