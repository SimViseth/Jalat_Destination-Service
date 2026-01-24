package com.jalat.destinationservice.feature.place_to_eat.service;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.feature.place_to_eat.dto.request.PlaceToEatRequest;
import com.jalat.destinationservice.feature.place_to_eat.dto.response.PlaceToEatRespoonse;

public interface PlaceToEatService {
    BaseResponse<PlaceToEatRespoonse> createPlaceToEat(PlaceToEatRequest placeToEatRequest);
}
