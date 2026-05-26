# Spring TPs ESAIP - 5e annee Cybersecurite & IoT

TPs Spring Boot realises dans le cadre des cours ESAIP.

## Contenu

### [tp02-di/](tp02-di/) - TP02 Injection de Dependances

- **Exercice 1** : `@Component`, `@Autowired` setter injection, `@Primary`
- **Exercice 2** : `@Profile("dev")` / `@Profile("prod")` / profil default
- **Exercice 3** : Dependance circulaire resolue avec `@Lazy`
- **TP avance** : `BavardService`, `@PostConstruct`, retour String REST

Endpoints : `GET /hello`, `GET /blabla`, `GET /notification`, `GET /circular`

### [tp03-bestioles/](tp03-bestioles/) - TP03 Spring Data JPA

Base de donnees `bestioles` (Species, Animal, Person, Role).

- Entites JPA : `@Entity`, `@ManyToOne`, `@ManyToMany`, `@JoinTable`
- Repositories : `JpaRepository`, requetes derivees, `@Query` JPQL, `@Modifying`
- `CommandLineRunner` pour tester CRUD au demarrage

## Lancer un TP

```bash
cd tp02-di    # ou tp03-bestioles
mvn spring-boot:run
```
