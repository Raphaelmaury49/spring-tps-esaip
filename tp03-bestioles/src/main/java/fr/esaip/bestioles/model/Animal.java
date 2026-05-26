package fr.esaip.bestioles.model;

import jakarta.persistence.*;

/**
 * Entite JPA mappee sur la table "animal".
 * Colonnes : id, color, name, sex, species_id (FK vers Species)
 * Relation ManyToOne : plusieurs animaux = une espece.
 */
@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "sex", nullable = false, length = 255)
    private String sex;

    @ManyToOne
    @JoinColumn(name = "species_id", nullable = false)
    private Species species;

    public Animal() {}

    public Animal(String name, String sex, String color, Species species) {
        this.name = name;
        this.sex = sex;
        this.color = color;
        this.species = species;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }
    public Species getSpecies() { return species; }
    public void setSpecies(Species species) { this.species = species; }

    @Override
    public String toString() {
        return "Animal{id=" + id + ", name='" + name + "', sex='" + sex
                + "', color='" + color + "', species=" + (species != null ? species.getCommonName() : "null") + "}";
    }
}
