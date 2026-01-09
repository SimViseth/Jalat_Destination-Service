package com.jalat.destinationservice.feature.destination.service.serviceImpl;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.core.BaseEntityResponseDto;
import com.jalat.destinationservice.feature.destination.dao.DestinationDao;
import com.jalat.destinationservice.feature.destination.dto.request.DestinationRequest;
import com.jalat.destinationservice.feature.destination.dto.response.DestinationResponse;
import com.jalat.destinationservice.feature.destination.entity.Destination;
import com.jalat.destinationservice.feature.destination.service.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jalat.destinationservice.app.AppConstant.SUCCESS;
import static com.jalat.destinationservice.app.AppConstant.SUCCESS_CODE;

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

        BaseEntityResponseDto<Destination> daoResponse = destinationDao.saveEntity(destination);

        // map entity to response
        DestinationResponse destinationResponse = DestinationResponse.builder()
                .destinationId(daoResponse.getEntity().getDestinationId())
                .destinationName(daoResponse.getEntity().getDestinationName())
                .destinationType(daoResponse.getEntity().getDestinationType())
                .image(daoResponse.getEntity().getImage())
                .description(daoResponse.getEntity().getDescription())
                .village(daoResponse.getEntity().getVillage())
                .commune(daoResponse.getEntity().getCommune())
                .district(daoResponse.getEntity().getDistrict())
                .province(daoResponse.getEntity().getProvince())
                .build();

        // API response
        BaseResponse<DestinationResponse> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Create destination successfully.");
        baseResponse.setData(destinationResponse);

        return baseResponse;

    }

    @Override
    public BaseResponse<List<DestinationResponse>> getAllDestinations() {

        BaseEntityResponseDto<Destination> daoResponse = destinationDao.findAll();

        DestinationResponse destinationResponse = DestinationResponse.builder()
                .destinationId(daoResponse.getEntity().getDestinationId())
                .destinationName(daoResponse.getEntity().getDestinationName())
                .destinationType(daoResponse.getEntity().getDestinationType())
                .description(daoResponse.getEntity().getDescription())
                .image(daoResponse.getEntity().getImage())
                .village(daoResponse.getEntity().getVillage())
                .commune(daoResponse.getEntity().getCommune())
                .district(daoResponse.getEntity().getDistrict())
                .province(daoResponse.getEntity().getProvince())
                .build();
    }
}
