package com.example.demolab1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotNull(message = "name can't be null")
    @Size(min = 2)
    String name;

    String secretRecepie = "Invisible fruit recepie";

    public String getSecretRecepie() {
        return secretRecepie;
    }

    public void setSecretRecepie(String secretRecepie) {
        this.secretRecepie = secretRecepie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
