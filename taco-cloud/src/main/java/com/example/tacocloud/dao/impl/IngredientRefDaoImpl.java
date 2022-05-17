package com.example.tacocloud.dao.impl;

import com.example.tacocloud.dao.IngredientRefDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class IngredientRefDaoImpl implements IngredientRefDao {

    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public IngredientRefDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public void saveIngredientRef(Long tacoId, String ingredientId, Long ingredientIndex) {
        IngredientRefDao mapper = sqlSessionTemplate.getMapper(IngredientRefDao.class);
        mapper.saveIngredientRef(tacoId, ingredientId, ingredientIndex);
    }

}
