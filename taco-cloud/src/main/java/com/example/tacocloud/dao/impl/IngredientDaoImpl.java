package com.example.tacocloud.dao.impl;

import com.example.tacocloud.dao.IngredientDao;
import com.example.tacocloud.domain.Ingredient;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class IngredientDaoImpl implements IngredientDao {

    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public IngredientDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<Ingredient> findAllIngredients() {
        IngredientDao mapper = sqlSessionTemplate.getMapper(IngredientDao.class);
        return mapper.findAllIngredients();
//        return sqlSessionTemplate.selectList("findAllIngredients");
    }

    @Override
    public Ingredient findIngredientById(String id) {
        IngredientDao mapper = sqlSessionTemplate.getMapper(IngredientDao.class);
        return mapper.findIngredientById(id);
//        return sqlSessionTemplate.selectOne("findIngredientById", id);
    }

    @Override
    public void saveIngredient(Ingredient ingredient) {
        IngredientDao mapper = sqlSessionTemplate.getMapper(IngredientDao.class);
        mapper.saveIngredient(ingredient);
//        sqlSessionTemplate.update("saveIngredient", ingredient);
    }
}
