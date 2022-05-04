package com.example.tacocloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface IngredientRefDao {

    @Update("insert into ingredient_ref(taco_id, ingredient_id, ingredient_index) " +
            "values(#{tacoId}, #{ingredientId}, #{ingredientIndex})")
    void saveIngredientRef(Long tacoId, String ingredientId, Long ingredientIndex);
}
