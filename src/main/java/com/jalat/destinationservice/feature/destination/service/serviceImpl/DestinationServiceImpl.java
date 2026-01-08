package com.jalat.destinationservice.feature.destination.service.serviceImpl;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.feature.destination.dao.DestinationDao;
import com.jalat.destinationservice.feature.destination.dto.request.DestinationRequest;
import com.jalat.destinationservice.feature.destination.dto.response.DestinationResponse;
import com.jalat.destinationservice.feature.destination.service.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DestinationServiceImpl implements DestinationService {

    private final DestinationDao destinationDao;
    @Override
    public BaseResponse<DestinationResponse> createDestination(DestinationRequest destinationRequest) {
        return null;
    }
}
