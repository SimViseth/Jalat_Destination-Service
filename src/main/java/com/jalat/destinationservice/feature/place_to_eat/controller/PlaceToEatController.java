package com.jalat.destinationservice.feature.place_to_eat.controller;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.feature.destination.dto.request.DestinationRequest;
import com.jalat.destinationservice.feature.destination.dto.response.DestinationResponse;
import com.jalat.destinationservice.feature.place_to_eat.dto.request.PlaceToEatRequest;
import com.jalat.destinationservice.feature.place_to_eat.dto.response.PlaceToEatRespoonse;
import com.jalat.destinationservice.feature.place_to_eat.service.PlaceToEatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/place-to-eat")
@RequiredArgsConstructor
public class PlaceToEatController {

    private final PlaceToEatService placeToEatService;

    PostMapping("/create")
    public BaseResponse<PlaceToEatRespoonse> createPlaceToEat(@RequestBody PlaceToEatRequest placeToEatRequest) {
        BaseResponse<PlaceToEatRespoonse> placeToEatResponse = placeToEatService.createPlaceToEat(placeToEatRequest);
        return destinationResponse;
    }

    @GetMapping("getAll")
    public BaseResponse<List<DestinationResponse>> getAllDestinations() {
        BaseResponse<List<DestinationResponse>> destinationResponse = placeToEatService.getAllDestinations();
        return destinationResponse;
    }
}
