package com.example.tacocloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {

    private final String id;
    private final String name;
    private final String type;
}
