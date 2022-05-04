package com.example.tacocloud.dao.impl;

import com.example.tacocloud.dao.TacoDao;
import com.example.tacocloud.domain.Taco;
import org.springframework.beans.factory.annotation.Autowired;

public class TacoDaoImpl implements TacoDao {

    private TacoDao tacoDao;

    @Autowired
    public TacoDaoImpl(TacoDao tacoDao) {
        this.tacoDao = tacoDao;
    }

    @Override
    public void saveTaco(Taco taco, Long tacoOrderId, Long tacoIndex) {
        tacoDao.saveTaco(taco, tacoOrderId, tacoIndex);
    }
}
