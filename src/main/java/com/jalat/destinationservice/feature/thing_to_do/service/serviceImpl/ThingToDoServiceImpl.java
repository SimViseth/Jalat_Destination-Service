package com.jalat.destinationservice.feature.thing_to_do.service.serviceImpl;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.core.BaseEntityResponseDto;
import com.jalat.destinationservice.feature.thing_to_do.dao.ThingToDoDao;
import com.jalat.destinationservice.feature.thing_to_do.dto.request.ThingToDoRequest;
import com.jalat.destinationservice.feature.thing_to_do.dto.response.ThingToDoResponse;
import com.jalat.destinationservice.feature.thing_to_do.entity.ThingToDo;
import com.jalat.destinationservice.feature.thing_to_do.service.ThingToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.jalat.destinationservice.app.AppConstant.SUCCESS;
import static com.jalat.destinationservice.app.AppConstant.SUCCESS_CODE;

@Service
@RequiredArgsConstructor
public class ThingToDoServiceImpl implements ThingToDoService {

    private final ThingToDoDao thingToDoDao;
    @Override
    public BaseResponse<ThingToDoResponse> createThingToDo(ThingToDoRequest thingToDoRequest) {

        ThingToDo thingToDo = new ThingToDo();
        thingToDo.setTitle(thingToDoRequest.getTitle());
        thingToDo.setImage(thingToDoRequest.getImage());
        thingToDo.setDescription(thingToDoRequest.getDescription());
        thingToDo.setVillage(thingToDoRequest.getVillage());
        thingToDo.setCommune(thingToDoRequest.getCommune());
        thingToDo.setDistrict(thingToDoRequest.getDistrict());
        thingToDo.setProvince(thingToDoRequest.getProvince());

        BaseEntityResponseDto<ThingToDo> daoResponse = thingToDoDao.saveEntity(thingToDo);
        ThingToDo response = daoResponse.getEntity();

        ThingToDoResponse thingToDoResponse = ThingToDoResponse.builder()
                .ttdId(response.getTtdId())
                .title(response.getTitle())
                .image(response.getImage())
                .description(response.getDescription())
                .village(response.getVillage())
                .commune(response.getCommune())
                .district(response.getDistrict())
                .province(response.getProvince())
                .build();

        BaseResponse<ThingToDoResponse> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Thing to do is created successfully");
        baseResponse.setData(thingToDoResponse);
        return baseResponse;
    }
}
