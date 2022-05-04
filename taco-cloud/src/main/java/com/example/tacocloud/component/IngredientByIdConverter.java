package com.example.tacocloud.component;

import com.example.tacocloud.domain.Ingredient;
import com.example.tacocloud.dao.IngredientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private IngredientDao ingredientDao;

    @Autowired
    public IngredientByIdConverter(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientDao.findIngredientById(id);
    }
}
