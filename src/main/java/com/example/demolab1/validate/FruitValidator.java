package com.example.demolab1.validate;

import com.example.demolab1.entity.Fruit;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FruitValidator {

    public boolean validate(Fruit fruit) {

        return fruit.getName() != null && !fruit.getName().isEmpty();

    }
}
