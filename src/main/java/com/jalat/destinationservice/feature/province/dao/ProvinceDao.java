package com.jalat.destinationservice.feature.province.dao;

import com.jalat.destinationservice.core.BaseDBDao;
import com.jalat.destinationservice.feature.province.entity.Province;
import com.jalat.destinationservice.feature.province.repository.ProvinceRepository;
import org.springframework.stereotype.Service;

@Service
public class ProvinceDao extends BaseDBDao<Province, Integer> {
    public ProvinceDao(ProvinceRepository provinceRepository) {
        super(provinceRepository);
    }
}
