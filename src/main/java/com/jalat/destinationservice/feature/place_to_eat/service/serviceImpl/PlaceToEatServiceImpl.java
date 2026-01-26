package com.jalat.destinationservice.feature.place_to_eat.service.serviceImpl;

import com.jalat.destinationservice.app.AppException;
import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.core.BaseEntityResponseDto;
import com.jalat.destinationservice.feature.destination.dto.response.DestinationResponse;
import com.jalat.destinationservice.feature.destination.entity.Destination;
import com.jalat.destinationservice.feature.place_to_eat.dao.PlaceToEatDao;
import com.jalat.destinationservice.feature.place_to_eat.dto.request.PlaceToEatRequest;
import com.jalat.destinationservice.feature.place_to_eat.dto.response.PlaceToEatResponse;
import com.jalat.destinationservice.feature.place_to_eat.entity.PlaceToEat;
import com.jalat.destinationservice.feature.place_to_eat.service.PlaceToEatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.jalat.destinationservice.app.AppConstant.SUCCESS;
import static com.jalat.destinationservice.app.AppConstant.SUCCESS_CODE;

@Service
@RequiredArgsConstructor
public class PlaceToEatServiceImpl implements PlaceToEatService {

    private final PlaceToEatDao placeToEatDao;
    @Override
    public BaseResponse<PlaceToEatResponse> createPlaceToEat(PlaceToEatRequest placeToEatRequest) {
        // map request to entity
        PlaceToEat placeToEat = new PlaceToEat();
        placeToEat.setShopName(placeToEatRequest.getShopName());
        placeToEat.setDescription(placeToEatRequest.getDescription());
        placeToEat.setImage(placeToEatRequest.getImage());
        placeToEat.setVillage(placeToEatRequest.getVillage());
        placeToEat.setCommune(placeToEatRequest.getCommune());
        placeToEat.setDistrict(placeToEatRequest.getDistrict());
        placeToEat.setProvince(placeToEatRequest.getProvince());

        BaseEntityResponseDto<PlaceToEat> daoResponse = placeToEatDao.saveEntity(placeToEat);

        // mpa entity to response
        PlaceToEatResponse placeToEatResponse = PlaceToEatResponse.builder()
                .eatId(daoResponse.getEntity().getEatId())
                .shopName(daoResponse.getEntity().getShopName())
                .image(daoResponse.getEntity().getImage())
                .description(daoResponse.getEntity().getDescription())
                .village(daoResponse.getEntity().getVillage())
                .commune(daoResponse.getEntity().getCommune())
                .district(daoResponse.getEntity().getDistrict())
                .province(daoResponse.getEntity().getProvince())
                .build();

        // API response
        BaseResponse<PlaceToEatResponse> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Create place to eat successfully.");
        baseResponse.setData(placeToEatResponse);

        return baseResponse;
    }

    @Override
    public BaseResponse<List<PlaceToEatResponse>> getAllPlaceToEat() {
        BaseEntityResponseDto<PlaceToEat> daoResponse = placeToEatDao.findAll();

        List<PlaceToEatResponse> placeToEatResponseList = new ArrayList<>();

        for (PlaceToEat placeToEat : daoResponse.getEntityList()) {
            // map entity to response
            PlaceToEatResponse placeToEatResponse = PlaceToEatResponse.builder()
                    .eatId(placeToEat.getEatId())
                    .shopName(placeToEat.getShopName())
                    .image(placeToEat.getImage())
                    .description(placeToEat.getDescription())
                    .village(placeToEat.getVillage())
                    .commune(placeToEat.getCommune())
                    .district(placeToEat.getDistrict())
                    .province(placeToEat.getProvince())
                    .build();
            placeToEatResponseList.add(placeToEatResponse);
        }

        // API response
        BaseResponse<List<PlaceToEatResponse>> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Get all place to eat successfully.");
        baseResponse.setData(placeToEatResponseList);
        return baseResponse;
    }

    @Override
    public BaseResponse<PlaceToEatResponse> getPlaceToEatById(Integer placeToEatId) {
        BaseEntityResponseDto<PlaceToEat> findPlaceToEatById = placeToEatDao.findById(placeToEatId);

        // map entity to response
        var placeToEatResponse = PlaceToEatResponse.builder()
                .eatId(findPlaceToEatById.getEntity().getEatId())
                .shopName(findPlaceToEatById.getEntity().getShopName())
                .image(findPlaceToEatById.getEntity().getImage())
                .description(findPlaceToEatById.getEntity().getDescription())
                .village(findPlaceToEatById.getEntity().getVillage())
                .commune(findPlaceToEatById.getEntity().getCommune())
                .district(findPlaceToEatById.getEntity().getDistrict())
                .province(findPlaceToEatById.getEntity().getProvince())
                .build();

        // API response
        BaseResponse<PlaceToEatResponse> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Get place to eat by Id successfully.");
        baseResponse.setData(placeToEatResponse);
        return baseResponse;
    }

    @Override
    public BaseResponse<PlaceToEatResponse> updatePlaceToEat(Integer placeToEatId, PlaceToEatRequest placeToEatRequest) {
        BaseEntityResponseDto<PlaceToEat> findPlaceToEat = placeToEatDao.findById(placeToEatId);

        PlaceToEat updatePlaceToEat = findPlaceToEat.getEntity();

        // map request to entity
        updatePlaceToEat.setShopName(placeToEatRequest.getShopName());
        updatePlaceToEat.setImage(placeToEatRequest.getImage());
        updatePlaceToEat.setDescription(placeToEatRequest.getDescription());
        updatePlaceToEat.setVillage(placeToEatRequest.getVillage());
        updatePlaceToEat.setCommune(placeToEatRequest.getCommune());
        updatePlaceToEat.setDistrict(placeToEatRequest.getDistrict());
        updatePlaceToEat.setProvince(placeToEatRequest.getProvince());

        BaseEntityResponseDto<PlaceToEat> saveUpdateData = placeToEatDao.saveEntity(updatePlaceToEat);

        // map entity to response
        var placeToEatResponse = PlaceToEatResponse.builder()
                .eatId(saveUpdateData.getEntity().getEatId())
                .shopName(saveUpdateData.getEntity().getShopName())
                .image(saveUpdateData.getEntity().getImage())
                .description(saveUpdateData.getEntity().getDescription())
                .village(saveUpdateData.getEntity().getVillage())
                .commune(saveUpdateData.getEntity().getCommune())
                .district(saveUpdateData.getEntity().getDistrict())
                .province(saveUpdateData.getEntity().getProvince())
                .build();

        // API response
        BaseResponse<PlaceToEatResponse> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Place to eat is updated successfully.");
        baseResponse.setData(placeToEatResponse);
        return baseResponse;
    }

    @Override
    public BaseResponse<Void> deletePlaceToEat(Integer placeToEatId) {
        BaseEntityResponseDto<PlaceToEat> findPlaceEat = placeToEatDao.findById(placeToEatId);

        if (findPlaceEat.getEntity() == null) {
            throw new AppException("Place to eat does not exist");
        }

        placeToEatDao.deleteEntity(placeToEatId);

        // API response
        BaseResponse<Void> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Place to eat is deleted successfully.");
        return baseResponse;
    }
}
