package com.example.tacocloud.dao.impl;

import com.example.tacocloud.dao.TacoDao;
import com.example.tacocloud.domain.Taco;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class TacoDaoImpl implements TacoDao {

    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public TacoDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public void saveTaco(Taco taco, Long tacoOrderId, Long tacoIndex) {
        TacoDao mapper = sqlSessionTemplate.getMapper(TacoDao.class);
        mapper.saveTaco(taco, tacoOrderId, tacoIndex);
    }
}
