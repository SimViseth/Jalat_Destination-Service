package com.jalat.destinationservice.feature.destination.service.serviceImpl;

import com.jalat.destinationservice.app.AppException;
import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.core.BaseEntityResponseDto;
import com.jalat.destinationservice.feature.destination.dao.DestinationDao;
import com.jalat.destinationservice.feature.destination.dto.request.DestinationRequest;
import com.jalat.destinationservice.feature.destination.dto.response.DestinationResponse;
import com.jalat.destinationservice.feature.destination.entity.Destination;
import com.jalat.destinationservice.feature.destination.repository.DestinationRepository;
import com.jalat.destinationservice.feature.destination.service.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.jalat.destinationservice.app.AppConstant.SUCCESS;
import static com.jalat.destinationservice.app.AppConstant.SUCCESS_CODE;

@Service
@RequiredArgsConstructor
public class DestinationServiceImpl implements DestinationService {

    private final DestinationDao destinationDao;
    private final DestinationRepository destinationRepository;
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

        List<DestinationResponse> destinationResponseList = new ArrayList<>();

        for (Destination destination : daoResponse.getEntityList()) {
            // map entity to response
            DestinationResponse destinationResponse = DestinationResponse.builder()
                    .destinationId(destination.getDestinationId())
                    .destinationName(destination.getDestinationName())
                    .destinationType(destination.getDestinationType())
                    .description(destination.getDescription())
                    .image(destination.getImage())
                    .village(destination.getVillage())
                    .commune(destination.getCommune())
                    .district(destination.getDistrict())
                    .province(destination.getProvince())
                    .build();
            destinationResponseList.add(destinationResponse);
        }

        // API response
        BaseResponse<List<DestinationResponse>> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Get all destinations successfully.");
        baseResponse.setData(destinationResponseList);
        return baseResponse;
    }

    @Override
    public BaseResponse<DestinationResponse> getDestinationById(Integer destinationId) {

        BaseEntityResponseDto<Destination> findDestinationById = destinationDao.findById(destinationId);

        // map entity to response
        DestinationResponse destinationResponse = DestinationResponse.builder()
                .destinationId(findDestinationById.getEntity().getDestinationId())
                .destinationName(findDestinationById.getEntity().getDestinationName())
                .description(findDestinationById.getEntity().getDescription())
                .image(findDestinationById.getEntity().getImage())
                .destinationType(findDestinationById.getEntity().getDestinationType())
                .village(findDestinationById.getEntity().getVillage())
                .commune(findDestinationById.getEntity().getCommune())
                .district(findDestinationById.getEntity().getDistrict())
                .province(findDestinationById.getEntity().getProvince())
                .build();

        // API response
        BaseResponse<DestinationResponse> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Get destination by Id successfully.");
        baseResponse.setData(destinationResponse);
        return baseResponse;
    }

    @Override
    public BaseResponse<DestinationResponse> getDestinationByName(String destinationName) {
        DestinationResponse findDestination = destinationRepository.findDestinationByProvinceOrDestinationNameLike(destinationName);

        // map entity to response
        DestinationResponse destinationResponse = DestinationResponse.builder()
                .destinationId(findDestination.getDestinationId())
                .destinationName(findDestination.getDestinationName())
                .description(findDestination.getDescription())
                .image(findDestination.getImage())
                .destinationType(findDestination.getDestinationType())
                .village(findDestination.getVillage())
                .commune(findDestination.getCommune())
                .district(findDestination.getDistrict())
                .province(findDestination.getProvince())
                .build();

        // API response
        BaseResponse<DestinationResponse> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Get destination successfully.");
        baseResponse.setData(destinationResponse);
        return baseResponse;
    }

    @Override
    public BaseResponse<DestinationResponse> updateDestination(Integer destinationId, DestinationRequest destinationRequest) {
        BaseEntityResponseDto<Destination> findDestination = destinationDao.findById(destinationId);

        Destination updateDestination = findDestination.getEntity();

        // map request to entity
        updateDestination.setDestinationName(destinationRequest.getDestinationName());
        updateDestination.setDestinationType(destinationRequest.getDestinationType());
        updateDestination.setImage(destinationRequest.getImage());
        updateDestination.setDescription(destinationRequest.getDescription());
        updateDestination.setVillage(destinationRequest.getVillage());
        updateDestination.setCommune(destinationRequest.getCommune());
        updateDestination.setDistrict(destinationRequest.getDistrict());
        updateDestination.setProvince(destinationRequest.getProvince());

        BaseEntityResponseDto<Destination> saveUpdateData = destinationDao.saveEntity(updateDestination);

        // map entity to response
        DestinationResponse destinationResponse = DestinationResponse.builder()
                .destinationName(saveUpdateData.getEntity().getDestinationName())
                .destinationType(saveUpdateData.getEntity().getDestinationType())
                .description(saveUpdateData.getEntity().getDescription())
                .image(saveUpdateData.getEntity().getImage())
                .village(saveUpdateData.getEntity().getVillage())
                .commune(saveUpdateData.getEntity().getCommune())
                .district(saveUpdateData.getEntity().getCommune())
                .province(saveUpdateData.getEntity().getProvince())
                .build();

        // API response
        BaseResponse<DestinationResponse> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Destination is updated successfully.");
        baseResponse.setData(destinationResponse);
        return baseResponse;
    }

    @Override
    public BaseResponse<Void> deleteDestination(Integer destinationId) {
        BaseEntityResponseDto<Destination> findDestination = destinationDao.findById(destinationId);

        if (findDestination.getEntity() == null) {
            throw new AppException("Destination does not exist");
        }

        destinationDao.deleteEntity(destinationId);

        BaseResponse<Void> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Destination is deleted successfully.");
        return baseResponse;

    }
}
