package com.example.tacocloud.dao.impl;

import com.example.tacocloud.dao.IngredientRefDao;
import org.springframework.beans.factory.annotation.Autowired;

public class IngredientRefDaoImpl implements IngredientRefDao {

    private IngredientRefDao ingredientRefDao;

    @Autowired
    public IngredientRefDaoImpl(IngredientRefDao ingredientRefDao) {
        this.ingredientRefDao = ingredientRefDao;
    }

    @Override
    public void saveIngredientRef(Long tacoId, String ingredientId, Long ingredientIndex) {
        ingredientRefDao.saveIngredientRef(tacoId, ingredientId, ingredientIndex);
    }

}
