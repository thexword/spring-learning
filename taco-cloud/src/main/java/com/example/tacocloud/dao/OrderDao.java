package com.example.tacocloud.dao;

import com.example.tacocloud.domain.TacoOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderDao {

    @Update("insert into taco_order(" +
            "delivery_name, delivery_street, delivery_city, delivery_state, delivery_zip, " +
            "cc_number, cc_expiration, cc_cvv, placed_at)" +
            "values(#{deliveryName}, #{deliveryStreet}, #{deliveryCity}, #{deliveryState}, #{deliveryZip}, " +
            "#{ccNumber}, #{ccExpiration}, #{ccCVV}, #{placedAt})")
    @SelectKey(statement = "select last_insert_id()", before = false, keyProperty = "id", resultType = Long.class)
    void saveOrder(TacoOrder tacoOrder);

}
