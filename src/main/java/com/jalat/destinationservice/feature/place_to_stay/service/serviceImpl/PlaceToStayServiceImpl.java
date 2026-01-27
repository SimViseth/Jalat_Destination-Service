package com.jalat.destinationservice.feature.place_to_stay.service.serviceImpl;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.core.BaseEntityResponseDto;
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
}
