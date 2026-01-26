package com.jalat.destinationservice.feature.place_to_eat.controller;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.feature.destination.dto.request.DestinationRequest;
import com.jalat.destinationservice.feature.destination.dto.response.DestinationResponse;
import com.jalat.destinationservice.feature.place_to_eat.dto.request.PlaceToEatRequest;
import com.jalat.destinationservice.feature.place_to_eat.dto.response.PlaceToEatResponse;
import com.jalat.destinationservice.feature.place_to_eat.service.PlaceToEatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/place-to-eat")
@RequiredArgsConstructor
public class PlaceToEatController {

    private final PlaceToEatService placeToEatService;

    @PostMapping("/create")
    public BaseResponse<PlaceToEatResponse> createPlaceToEat(@RequestBody PlaceToEatRequest placeToEatRequest) {
        BaseResponse<PlaceToEatResponse> placeToEatResponse = placeToEatService.createPlaceToEat(placeToEatRequest);
        return placeToEatResponse;
    }
    @GetMapping("getAll")
    public BaseResponse<List<PlaceToEatResponse>> getAllPlaceToEat() {
        BaseResponse<List<PlaceToEatResponse>> placeToEatResponse = placeToEatService.getAllPlaceToEat();
        return placeToEatResponse;
    }

    @GetMapping("/getById/{placeToEatId}")
    public BaseResponse<PlaceToEatResponse> getPlaceToEatById(@PathVariable Integer placeToEatId) {
        BaseResponse<PlaceToEatResponse> placeToEatResponse = placeToEatService.getPlaceToEatById(placeToEatId);
        return placeToEatResponse;
    }
    @PutMapping("/update/{placeToEatId}")
    public BaseResponse<PlaceToEatResponse> updatePlaceToEat(@PathVariable Integer placeToEatId, @RequestBody PlaceToEatRequest placeToEatRequest) {
        BaseResponse<PlaceToEatResponse> placeToEatResponse = placeToEatService.updatePlaceToEat(placeToEatId, placeToEatRequest);
        return placeToEatResponse;
    }

    @DeleteMapping("/delete/{placeToEatId}")
    public BaseResponse<Void> deletePlaceToEat(@PathVariable Integer placeToEatId) {
        BaseResponse<Void> placeToEatResponse = placeToEatService.deletePlaceToEat(placeToEatId);
        return placeToEatResponse;
    }
}
