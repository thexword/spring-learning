package com.example.tacocloud.dao;

import com.example.tacocloud.domain.Taco;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface TacoDao {

    @Insert("insert into taco(name, taco_order_id, taco_index, created_at) " +
            "values(#{taco.name}, #{tacoOrderId}, #{tacoIndex}, #{taco.createdAt})")
    @SelectKey(statement = "select last_insert_id()", before = false, keyProperty = "taco.id", resultType = Long.class)
    void saveTaco(Taco taco, Long tacoOrderId, Long tacoIndex);
}
