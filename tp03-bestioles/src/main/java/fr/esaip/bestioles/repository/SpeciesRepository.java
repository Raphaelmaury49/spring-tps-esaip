package fr.esaip.bestioles.repository;

import fr.esaip.bestioles.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository Species - JpaRepository fournit findAll, findById, save, delete, count...
 * Methodes derivees ajoutees :
 *   findByCommonName        -> SELECT * FROM species WHERE common_name = ?
 *   findByLatinNameContains -> SELECT * FROM species WHERE latin_name LIKE %?%
 */
@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    List<Species> findByCommonName(String commonName);
    List<Species> findByLatinNameContains(String keyword);
}
