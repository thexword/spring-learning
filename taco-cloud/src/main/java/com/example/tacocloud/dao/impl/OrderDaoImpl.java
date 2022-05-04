package com.example.tacocloud.dao.impl;

import com.example.tacocloud.dao.OrderDao;
import com.example.tacocloud.domain.TacoOrder;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDaoImpl implements OrderDao {

    private OrderDao orderDao;

    @Autowired
    public OrderDaoImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public void saveOrder(TacoOrder tacoOrder) {
        orderDao.saveOrder(tacoOrder);
    }
}
