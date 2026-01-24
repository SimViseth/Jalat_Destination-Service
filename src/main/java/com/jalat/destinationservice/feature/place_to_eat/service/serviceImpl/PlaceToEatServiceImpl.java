package com.jalat.destinationservice.feature.place_to_eat.service.serviceImpl;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.feature.place_to_eat.dao.PlaceToEatDao;
import com.jalat.destinationservice.feature.place_to_eat.dto.request.PlaceToEatRequest;
import com.jalat.destinationservice.feature.place_to_eat.dto.response.PlaceToEatRespoonse;
import com.jalat.destinationservice.feature.place_to_eat.service.PlaceToEatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceToEatServiceImpl implements PlaceToEatService {

    private final PlaceToEatDao placeToEatDao;
    @Override
    public BaseResponse<PlaceToEatRespoonse> createPlaceToEat(PlaceToEatRequest placeToEatRequest) {
        return null;
    }
}
