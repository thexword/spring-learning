package com.example.tacocloud.dao;

import com.example.tacocloud.domain.Ingredient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface IngredientDao {

    @Select("select * from ingredient")
    List<Ingredient> findAllIngredients();

    @Select("select * from ingredient where id=#{id}")
    Ingredient findIngredientById(String id);

    @Update("insert into ingredient(id, name, type) " +
            "values(#{id}, #{name}, #{type})")
    void saveIngredient(Ingredient ingredient);

}
