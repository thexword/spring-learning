package com.example.tacocloud.dao.impl;

import com.example.tacocloud.dao.OrderDao;
import com.example.tacocloud.domain.TacoOrder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDaoImpl implements OrderDao {

    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public OrderDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public void saveOrder(TacoOrder tacoOrder) {
        OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
        mapper.saveOrder(tacoOrder);
    }
}
