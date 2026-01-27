package com.jalat.destinationservice.feature.place_to_stay.service.serviceImpl;

import com.jalat.destinationservice.app.AppException;
import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.core.BaseEntityResponseDto;
import com.jalat.destinationservice.feature.destination.dao.DestinationDao;
import com.jalat.destinationservice.feature.destination.entity.Destination;
import com.jalat.destinationservice.feature.place_to_eat.dto.response.PlaceToEatResponse;
import com.jalat.destinationservice.feature.place_to_eat.entity.PlaceToEat;
import com.jalat.destinationservice.feature.place_to_stay.dao.PlaceToStayDao;
import com.jalat.destinationservice.feature.place_to_stay.dto.request.PlaceToStayRequest;
import com.jalat.destinationservice.feature.place_to_stay.dto.response.PlaceToStayResponse;
import com.jalat.destinationservice.feature.place_to_stay.entity.PlaceToStay;
import com.jalat.destinationservice.feature.place_to_stay.service.PlaceToStayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.jalat.destinationservice.app.AppConstant.SUCCESS;
import static com.jalat.destinationservice.app.AppConstant.SUCCESS_CODE;

@Service
@AllArgsConstructor
public class PlaceToStayServiceImpl implements PlaceToStayService {

    private final PlaceToStayDao placeToStayDao;
    private final DestinationDao destinationDao;
    @Override
    public BaseResponse<PlaceToStayResponse> createPlaceToStay(PlaceToStayRequest placeToStayRequest) {
        // map request to entity
        PlaceToStay placeToStay = new PlaceToStay();
        placeToStay.setAccommodationName(placeToStayRequest.getAccommodationName());
        placeToStay.setType(placeToStayRequest.getType());
        placeToStay.setDescription(placeToStayRequest.getDescription());
        placeToStay.setImage(placeToStayRequest.getImage());
        placeToStay.setVillage(placeToStayRequest.getVillage());
        placeToStay.setCommune(placeToStayRequest.getCommune());
        placeToStay.setDistrict(placeToStayRequest.getDistrict());
        placeToStay.setProvince(placeToStayRequest.getProvince());
        //placeToStay.setDestination(placeToStayRequest.getDestination());

        BaseEntityResponseDto<PlaceToStay> daoResponse = placeToStayDao.saveEntity(placeToStay);

        // mpa entity to response
        PlaceToStayResponse placeToStayResponse = PlaceToStayResponse.builder()
                .stayId(daoResponse.getEntity().getStayId())
                .accommodationName(daoResponse.getEntity().getAccommodationName())
                .type(daoResponse.getEntity().getType())
                .image(daoResponse.getEntity().getImage())
                .description(daoResponse.getEntity().getDescription())
                .village(daoResponse.getEntity().getVillage())
                .commune(daoResponse.getEntity().getCommune())
                .district(daoResponse.getEntity().getDistrict())
                .province(daoResponse.getEntity().getProvince())
                .build();

        // API response
        BaseResponse<PlaceToStayResponse> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Create place to stay successfully.");
        baseResponse.setData(placeToStayResponse);

        return baseResponse;
    }

    @Override
    public BaseResponse<List<PlaceToStayResponse>> getAllPlaceToStay() {
        BaseEntityResponseDto<PlaceToStay> daoResponse = placeToStayDao.findAll();

        List<PlaceToStayResponse> placeToStayResponseList = new ArrayList<>();

        for (PlaceToStay placeToStay : daoResponse.getEntityList()) {
            // map entity to response
            PlaceToStayResponse placeToStayResponse = PlaceToStayResponse.builder()
                    .stayId(placeToStay.getStayId())
                    .accommodationName(placeToStay.getAccommodationName())
                    .image(placeToStay.getImage())
                    .type(placeToStay.getType())
                    .description(placeToStay.getDescription())
                    .village(placeToStay.getVillage())
                    .commune(placeToStay.getCommune())
                    .district(placeToStay.getDistrict())
                    .province(placeToStay.getProvince())
                    .build();
            placeToStayResponseList.add(placeToStayResponse);
        }

        // API response
        BaseResponse<List<PlaceToStayResponse>> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Get all place to stay successfully.");
        baseResponse.setData(placeToStayResponseList);
        return baseResponse;
    }

    @Override
    public BaseResponse<PlaceToStayResponse> getPlaceToStayById(Integer placeToStayId) {
        BaseEntityResponseDto<PlaceToStay> findPlaceToStayById = placeToStayDao.findById(placeToStayId);

        // map entity to response
        var placeToStayResponse = PlaceToStayResponse.builder()
                .stayId(findPlaceToStayById.getEntity().getStayId())
                .accommodationName(findPlaceToStayById.getEntity().getAccommodationName())
                .image(findPlaceToStayById.getEntity().getImage())
                .type(findPlaceToStayById.getEntity().getType())
                .description(findPlaceToStayById.getEntity().getDescription())
                .village(findPlaceToStayById.getEntity().getVillage())
                .commune(findPlaceToStayById.getEntity().getCommune())
                .district(findPlaceToStayById.getEntity().getDistrict())
                .province(findPlaceToStayById.getEntity().getProvince())
                .build();

        // API response
        BaseResponse<PlaceToStayResponse> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Get place to stay by Id successfully.");
        baseResponse.setData(placeToStayResponse);
        return baseResponse;
    }

    @Override
    public BaseResponse<PlaceToStayResponse> updatePlaceToStay(Integer placeToStayId, PlaceToStayRequest placeToStayRequest) {
        BaseEntityResponseDto<PlaceToStay> findPlaceToStay = placeToStayDao.findById(placeToStayId);

        PlaceToStay updatePlaceToStay = findPlaceToStay.getEntity();

        // map request to entity
        updatePlaceToStay.setAccommodationName(placeToStayRequest.getAccommodationName());
        updatePlaceToStay.setType(placeToStayRequest.getType());
        updatePlaceToStay.setImage(placeToStayRequest.getImage());
        updatePlaceToStay.setDescription(placeToStayRequest.getDescription());
        updatePlaceToStay.setVillage(placeToStayRequest.getVillage());
        updatePlaceToStay.setCommune(placeToStayRequest.getCommune());
        updatePlaceToStay.setDistrict(placeToStayRequest.getDistrict());
        updatePlaceToStay.setProvince(placeToStayRequest.getProvince());

        BaseEntityResponseDto<PlaceToStay> saveUpdateData = placeToStayDao.saveEntity(updatePlaceToStay);

        // map entity to response
        var placeToStayResponse = PlaceToStayResponse.builder()
                .stayId(saveUpdateData.getEntity().getStayId())
                .accommodationName(saveUpdateData.getEntity().getAccommodationName())
                .image(saveUpdateData.getEntity().getImage())
                .type(saveUpdateData.getEntity().getType())
                .description(saveUpdateData.getEntity().getDescription())
                .village(saveUpdateData.getEntity().getVillage())
                .commune(saveUpdateData.getEntity().getCommune())
                .district(saveUpdateData.getEntity().getDistrict())
                .province(saveUpdateData.getEntity().getProvince())
                .build();

        // API response
        BaseResponse<PlaceToStayResponse> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Place to stay is updated successfully.");
        baseResponse.setData(placeToStayResponse);
        return baseResponse;
    }

    @Override
    public BaseResponse<Void> deletePlaceToStay(Integer placeToStayId) {
        BaseEntityResponseDto<PlaceToStay> findPlaceStay = placeToStayDao.findById(placeToStayId);

        if (findPlaceStay.getEntity() == null) {
            throw new AppException("Place to stay does not exist");
        }

        placeToStayDao.deleteEntity(placeToStayId);

        // API response
        BaseResponse<Void> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Place to stay is deleted successfully.");
        return baseResponse;
    }
}
