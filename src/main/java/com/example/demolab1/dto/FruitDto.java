package com.example.demolab1.dto;

public class FruitDto {
    private Long id;
    private String fruitName;

    public FruitDto() {
    }

    public FruitDto(Long id, String name) {
        this.id = id;
        this.fruitName = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return fruitName;
    }

    public void setName(String name) {
        this.fruitName = name;
    }
}
