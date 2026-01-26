package com.jalat.destinationservice.feature.place_to_stay.dao;

import com.jalat.destinationservice.core.BaseDBDao;
import com.jalat.destinationservice.feature.place_to_stay.entity.PlaceToStay;
import com.jalat.destinationservice.feature.place_to_stay.repository.PlaceToStayRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaceToStayDao extends BaseDBDao<PlaceToStay, Integer> {
    public PlaceToStayDao(PlaceToStayRepository placeToStayRepository) {
        super(placeToStayRepository);
    }
}
