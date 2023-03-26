package com.example.demolab1.repository;

import com.example.demolab1.entity.Fruit;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class FruitRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Fruit> findAll(){

        var query = entityManager.createQuery("select f from Fruit f");
        return (List<Fruit>) query.getResultList();
    }

    public Optional<Fruit>findOne(Long id){
        return Optional.ofNullable(entityManager.find(Fruit.class, id));
    }
    public void insertFruit(Fruit fruit){

        entityManager.persist(fruit);
    }
    public void deleteFruit(Long id){

        var fruit = findOne(id);
        fruit.ifPresent((f)->entityManager.remove(f));

    }

}
