package com.jalat.destinationservice.feature.place_to_eat.dao;

import com.jalat.destinationservice.core.BaseDBDao;
import com.jalat.destinationservice.feature.place_to_eat.entity.PlaceToEat;
import com.jalat.destinationservice.feature.place_to_eat.repository.PlaceToEatRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaceToEatDao extends BaseDBDao<PlaceToEat, Integer> {
    public PlaceToEatDao(PlaceToEatRepository placeToEatRepository) {
        super(placeToEatRepository);
    }
}
