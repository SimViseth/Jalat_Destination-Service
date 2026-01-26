package com.jalat.destinationservice.feature.place_to_stay.controller;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.feature.place_to_eat.dto.request.PlaceToEatRequest;
import com.jalat.destinationservice.feature.place_to_eat.dto.response.PlaceToEatResponse;
import com.jalat.destinationservice.feature.place_to_stay.dto.request.PlaceToStayRequest;
import com.jalat.destinationservice.feature.place_to_stay.dto.response.PlaceToStayResponse;
import com.jalat.destinationservice.feature.place_to_stay.service.PlaceToStayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/place-to-stay")
@RequiredArgsConstructor
public class PlaceToStayController {

    private final PlaceToStayService placeToStayService;

    @PostMapping("/create")
    public BaseResponse<PlaceToStayResponse> createPlaceToStay(@RequestBody PlaceToStayRequest placeToStayRequest) {
        BaseResponse<PlaceToStayResponse> placeToStayResponse = placeToStayService.createPlaceToStay(placeToStayRequest);
        return placeToStayResponse;
    }
    @GetMapping("getAll")
    public BaseResponse<List<PlaceToStayResponse>> getAllPlaceToStay() {
        BaseResponse<List<PlaceToStayResponse>> placeToStayResponse = placeToStayService.getAllPlaceToStay();
        return placeToStayResponse;
    }
}
