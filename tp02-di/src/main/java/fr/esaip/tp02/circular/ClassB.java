package fr.esaip.tp02.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Exercice 3 - ClassB depend de ClassA.
 * La resolution du cycle est geree dans ClassA avec @Lazy.
 */
@Component
public class ClassB {

    private final ClassA classA;

    @Autowired
    public ClassB(ClassA classA) {
        this.classA = classA;
        System.out.println("[ClassB] Instanciee");
    }

    public String repondre() {
        return "Reponse de ClassB (connait ClassA : " + classA.getClass().getSimpleName() + ")";
    }
}
