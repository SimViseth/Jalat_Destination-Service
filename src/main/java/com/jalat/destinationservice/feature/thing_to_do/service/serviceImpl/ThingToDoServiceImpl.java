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

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public BaseResponse<List<ThingToDoResponse>> getAllThingToDo() {
        BaseEntityResponseDto<ThingToDo> findThingToDo = thingToDoDao.findAll();

        List<ThingToDoResponse> thingToDoResponseList = new ArrayList<>();

        for (ThingToDo thingToDo : findThingToDo.getEntityList()) {
            ThingToDoResponse thingToDoResponse = ThingToDoResponse.builder()
                    .ttdId(thingToDo.getTtdId())
                    .title(thingToDo.getTitle())
                    .description(thingToDo.getDescription())
                    .image(thingToDo.getImage())
                    .village(thingToDo.getVillage())
                    .commune(thingToDo.getCommune())
                    .district(thingToDo.getDistrict())
                    .province(thingToDo.getProvince())
                    .build();
            thingToDoResponseList.add(thingToDoResponse);
        }

        BaseResponse<List<ThingToDoResponse>> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Get all thing to do successfully");
        baseResponse.setData(thingToDoResponseList);
        return baseResponse;
    }

    @Override
    public BaseResponse<ThingToDoResponse> updateThingToDo(Integer thingToDoId, ThingToDoRequest thingToDoRequest) {
        BaseEntityResponseDto<ThingToDo> findTtd = thingToDoDao.findById(thingToDoId);

        ThingToDo updateData = findTtd.getEntity();

        updateData.setTitle(thingToDoRequest.getTitle());
        updateData.setImage(thingToDoRequest.getImage());
        updateData.setDescription(thingToDoRequest.getDescription());
        updateData.setVillage(thingToDoRequest.getVillage());
        updateData.setCommune(thingToDoRequest.getCommune());
        updateData.setDistrict(thingToDoRequest.getDistrict());
        updateData.setProvince(thingToDoRequest.getProvince());

        BaseEntityResponseDto<ThingToDo> saveUpdateData = thingToDoDao.saveEntity(updateData);
        ThingToDo saveData = saveUpdateData.getEntity();

        ThingToDoResponse thingToDoResponse = ThingToDoResponse.builder()
                .ttdId(saveData.getTtdId())
                .title(saveData.getTitle())
                .image(saveData.getImage())
                .description(saveData.getDescription())
                .village(saveData.getVillage())
                .commune(saveData.getCommune())
                .district(saveData.getDistrict())
                .province(saveData.getProvince())
                .build();

        BaseResponse<ThingToDoResponse> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Thing to do updated successfully");
        baseResponse.setData(thingToDoResponse);
        return baseResponse;
    }
}
