package fr.esaip.tp02.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Exercice 3 - Dependance circulaire : ClassA -> ClassB -> ClassA
 *
 * PROBLEME : sans @Lazy, Spring leve BeanCurrentlyInCreationException au demarrage.
 * Stack: classA -> classB -> classA (cycle infini)
 *
 * SOLUTION : @Lazy sur l'injection de ClassB dans ClassA.
 * Spring cree un proxy CGLIB de ClassB au lieu de l'instancier immediatement.
 * Le bean reel est cree lors du premier appel effectif a classB.
 */
@Component
public class ClassA {

    private final ClassB classB;

    @Autowired
    public ClassA(@Lazy ClassB classB) {
        this.classB = classB;
        System.out.println("[ClassA] Instanciee (ClassB est un lazy proxy pour l'instant)");
    }

    public String direBonjour() {
        return "ClassA dit bonjour ! ClassB repond : " + classB.repondre();
    }
}
