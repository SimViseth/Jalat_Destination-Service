package com.jalat.destinationservice.feature.place_to_eat.service;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.feature.place_to_eat.dto.request.PlaceToEatRequest;
import com.jalat.destinationservice.feature.place_to_eat.dto.response.PlaceToEatResponse;

import java.util.List;

public interface PlaceToEatService {
    BaseResponse<PlaceToEatResponse> createPlaceToEat(PlaceToEatRequest placeToEatRequest);

    BaseResponse<List<PlaceToEatResponse>> getAllPlaceToEat();

    BaseResponse<PlaceToEatResponse> getPlaceToEatById(Integer placeToEatId);

    BaseResponse<PlaceToEatResponse> updatePlaceToEat(Integer placeToEatId, PlaceToEatRequest placeToEatRequest);

    BaseResponse<Void> deletePlaceToEat(Integer placeToEatId);
}
