package com.jalat.destinationservice.feature.place_to_stay.service;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.feature.place_to_stay.dto.request.PlaceToStayRequest;
import com.jalat.destinationservice.feature.place_to_stay.dto.response.PlaceToStayResponse;

import java.util.List;

public interface PlaceToStayService {
    BaseResponse<PlaceToStayResponse> createPlaceToStay(PlaceToStayRequest placeToStayRequest);

    BaseResponse<List<PlaceToStayResponse>> getAllPlaceToStay();
}
