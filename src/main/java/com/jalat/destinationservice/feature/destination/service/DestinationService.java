package com.jalat.destinationservice.feature.destination.service;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.feature.destination.dto.request.DestinationRequest;
import com.jalat.destinationservice.feature.destination.dto.response.DestinationResponse;

public interface DestinationService {
    BaseResponse<DestinationResponse> createDestination(DestinationRequest destinationRequest);
}
