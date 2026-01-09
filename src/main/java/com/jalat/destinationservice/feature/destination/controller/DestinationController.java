package com.jalat.destinationservice.feature.destination.controller;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.feature.destination.dto.request.DestinationRequest;
import com.jalat.destinationservice.feature.destination.dto.response.DestinationResponse;
import com.jalat.destinationservice.feature.destination.service.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/destination")
@RequiredArgsConstructor
public class DestinationController {

    private final DestinationService destinationService;

    @PostMapping("/create")
    public BaseResponse<DestinationResponse> createDestination(@RequestBody DestinationRequest destinationRequest) {
        BaseResponse<DestinationResponse> destinationResponse = destinationService.createDestination(destinationRequest);
        return destinationResponse;
    }

    @GetMapping("getAll")
    public BaseResponse<List<DestinationResponse>> getAllDestinations() {
        BaseResponse<List<DestinationResponse>> destinationResponse = destinationService.getAllDestinations();
        return destinationResponse;
    }
}
