package com.jalat.destinationservice.feature.destination.service.serviceImpl;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.enums.EnumDestinationType;
import com.jalat.destinationservice.feature.destination.dao.DestinationDao;
import com.jalat.destinationservice.feature.destination.dto.request.DestinationRequest;
import com.jalat.destinationservice.feature.destination.dto.response.DestinationResponse;
import com.jalat.destinationservice.feature.destination.entity.Destination;
import com.jalat.destinationservice.feature.destination.service.DestinationService;
import com.jalat.destinationservice.feature.province.entity.Province;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DestinationServiceImpl implements DestinationService {

    private final DestinationDao destinationDao;
    @Override
    public BaseResponse<DestinationResponse> createDestination(DestinationRequest destinationRequest) {

        // map request to entity
        Destination destination = new Destination();
        destination.setDestinationName(destinationRequest.getDestinationName());
        destination.setDestinationType(destinationRequest.getDestinationType());
        destination.setImage("");
        destination.setDescription(destinationRequest.getDescription());
        destination.setVillage(destinationRequest.getVillage());
        destination.setCommune(destinationRequest.getCommune());
        destination.setDistrict(destinationRequest.getDistrict());
        destination.setProvince(destinationRequest.getProvince());
    }
}
