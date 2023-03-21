package com.example.demolab1.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@ApplicationScoped
public class FruitRepository {

    @PersistenceContext
    EntityManager entityManager;

}
