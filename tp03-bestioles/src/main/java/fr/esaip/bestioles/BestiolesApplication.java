package fr.esaip.bestioles;

import fr.esaip.bestioles.model.Animal;
import fr.esaip.bestioles.model.Person;
import fr.esaip.bestioles.model.Species;
import fr.esaip.bestioles.repository.AnimalRepository;
import fr.esaip.bestioles.repository.PersonRepository;
import fr.esaip.bestioles.repository.RoleRepository;
import fr.esaip.bestioles.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

/**
 * TP03 - Spring Data JPA : Bestioles
 * Implements CommandLineRunner pour executer du code apres demarrage Spring.
 * Demontre : findAll, save, findById, delete, @Query, @Modifying sur chaque repository.
 *
 * Prerequis : executer dump-bestioles-2025-12-10.sql sur MariaDB/MySQL.
 */
@SpringBootApplication
public class BestiolesApplication implements CommandLineRunner {

    @Autowired private SpeciesRepository speciesRepository;
    @Autowired private AnimalRepository animalRepository;
    @Autowired private PersonRepository personRepository;
    @Autowired private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(BestiolesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n========== TP03 - Tests Repository ==========\n");
        testSpeciesRepository();
        testAnimalRepository();
        testPersonRepository();
        System.out.println("\n========== Fin des tests ==========\n");
    }

    private void testSpeciesRepository() {
        System.out.println("--- SpeciesRepository ---");
        List<Species> all = speciesRepository.findAll();
        System.out.println("findAll (" + all.size() + ") : " + all);

        Species tortue = speciesRepository.save(new Species("Tortue", "Testudo hermanni"));
        System.out.println("save : " + tortue);

        Optional<Species> found = speciesRepository.findById(tortue.getId());
        found.ifPresent(s -> System.out.println("findById : " + s));

        List<Species> chats = speciesRepository.findByCommonName("Chat");
        System.out.println("findByCommonName('Chat') : " + chats);

        speciesRepository.delete(tortue);
        System.out.println("delete OK. count=" + speciesRepository.count() + "\n");
    }

    private void testAnimalRepository() {
        System.out.println("--- AnimalRepository ---");
        System.out.println("findAll (" + animalRepository.count() + " animaux)");

        List<Animal> males = animalRepository.findBySex("M");
        System.out.println("findBySex('M') : " + males);

        List<Animal> chats = animalRepository.findBySpecies_CommonName("Chat");
        System.out.println("findBySpecies_CommonName('Chat') : " + chats);

        List<Animal> blancs = animalRepository.findByColorJpql("Blanc");
        System.out.println("@Query findByColor('Blanc') : " + blancs);

        Species catSpecies = speciesRepository.findByCommonName("Chat").get(0);
        Animal test = animalRepository.save(new Animal("TestChat", "F", "Tigre", catSpecies));
        System.out.println("save : " + test);
        animalRepository.delete(test);
        System.out.println("delete OK. count=" + animalRepository.count() + "\n");
    }

    private void testPersonRepository() {
        System.out.println("--- PersonRepository ---");
        System.out.println("findAll (" + personRepository.count() + " personnes)");

        Optional<Person> p = personRepository.findByLogin("hla");
        p.ifPresent(x -> System.out.println("findByLogin('hla') : " + x));

        List<Person> actifs = personRepository.findByActiveTrue();
        System.out.println("findByActiveTrue : " + actifs.size() + " personnes");

        List<Person> seniors = personRepository.findByAgeGreaterThan(50);
        System.out.println("findByAgeGreaterThan(50) : " + seniors);

        List<Person> henriList = personRepository.findByFirstnameJpql("Henri");
        System.out.println("@Query findByFirstname('Henri') : " + henriList);

        Person test = personRepository.save(new Person("Test", "User", "test_login_tp03", "pwd"));
        test.setAge(25);
        test = personRepository.save(test);
        System.out.println("save : " + test);

        personRepository.updateActiveByLogin("test_login_tp03", false);
        personRepository.findByLogin("test_login_tp03")
                .ifPresent(x -> System.out.println("apres updateActive : " + x));

        personRepository.delete(test);
        System.out.println("delete OK. count=" + personRepository.count() + "\n");
    }
}
