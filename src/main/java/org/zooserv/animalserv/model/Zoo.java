package org.zooserv.animalserv.model;

import jakarta.persistence.*;

@Entity
@Table(name = "zoo")
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "animalres")
    private String animalres;

    public Zoo() {}

    public Zoo(String animalres) {
        this.animalres = animalres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnimalserv() {
        return animalres;
    }

    public void setAnimalserv(String animalres) {
        this.animalres = animalres;
    }
}
