package fr.esaip.bestioles;

import fr.esaip.bestioles.model.Species;
import fr.esaip.bestioles.repository.SpeciesRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires sur SpeciesRepository avec H2 en memoire.
 * @SpringBootTest : charge le contexte Spring complet.
 * @Transactional  : rollback automatique apres chaque test.
 */
@SpringBootTest
@Transactional
class SpeciesRepositoryTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private SpeciesRepository speciesRepository;

    @BeforeEach
    void initData() {
        em.clear();
        em.persist(new Species("Chat", "Felis silvestris catus"));
        em.persist(new Species("Chien", "Canis lupus familiaris"));
        em.persist(new Species("Lapin", "Oryctolagus cuniculus"));
        em.flush();
    }

    @Test
    void findAll_shouldReturn3Species() {
        List<Species> result = speciesRepository.findAll();
        assertEquals(3, result.size());
    }

    @Test
    void findByCommonName_chat_shouldReturn1() {
        List<Species> result = speciesRepository.findByCommonName("Chat");
        assertEquals(1, result.size());
        assertEquals("Felis silvestris catus", result.get(0).getLatinName());
    }

    @Test
    void save_shouldPersistNewSpecies() {
        Species tortue = speciesRepository.save(new Species("Tortue", "Testudo hermanni"));
        assertNotNull(tortue.getId());
        assertEquals(4, speciesRepository.count());
    }

    @Test
    void findById_shouldReturnSpecies() {
        Species chat = speciesRepository.findByCommonName("Chat").get(0);
        Optional<Species> found = speciesRepository.findById(chat.getId());
        assertTrue(found.isPresent());
        assertEquals("Chat", found.get().getCommonName());
    }

    @Test
    void delete_shouldRemoveSpecies() {
        Species chat = speciesRepository.findByCommonName("Chat").get(0);
        speciesRepository.delete(chat);
        assertEquals(2, speciesRepository.count());
    }

    @Test
    void findByLatinNameContains_catus_shouldReturn1() {
        List<Species> result = speciesRepository.findByLatinNameContains("catus");
        assertEquals(1, result.size());
    }
}
