package fr.esaip.bestioles.repository;

import fr.esaip.bestioles.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository Animal - requetes derivees + @Query JPQL
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> findByName(String name);

    List<Animal> findBySex(String sex);

    /** Join automatique sur Species via le nom du champ "species.commonName" */
    List<Animal> findBySpecies_CommonName(String commonName);

    /** @Query JPQL : recherche par couleur */
    @Query("from Animal a where a.color = :color")
    List<Animal> findByColorJpql(@Param("color") String color);
}
