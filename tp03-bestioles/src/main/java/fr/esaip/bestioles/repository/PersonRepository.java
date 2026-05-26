package fr.esaip.bestioles.repository;

import fr.esaip.bestioles.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Repository Person - requetes derivees, @Query JPQL et @Modifying
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByLogin(String login);

    List<Person> findByLastname(String lastname);

    List<Person> findByFirstnameContainsOrLastnameContains(String firstname, String lastname);

    List<Person> findByActiveTrue();

    List<Person> findByAgeGreaterThan(int age);

    /** @Query JPQL */
    @Query("from Person p where p.firstname = :firstname")
    List<Person> findByFirstnameJpql(@Param("firstname") String firstname);

    /** @Modifying : mise a jour via JPQL, @Transactional obligatoire */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Person p set p.active = :active where p.login = :login")
    int updateActiveByLogin(@Param("login") String login, @Param("active") boolean active);
}
