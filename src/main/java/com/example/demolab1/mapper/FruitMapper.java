package com.example.demolab1.mapper;

import com.example.demolab1.dto.FruitDto;
import com.example.demolab1.entity.Fruit;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
@ApplicationScoped
public class FruitMapper {
    public List<FruitDto> map(List<Fruit> all) {

        return all.stream().map(fruit -> new FruitDto(fruit.getId(), fruit.getName())).toList();
    }
}
