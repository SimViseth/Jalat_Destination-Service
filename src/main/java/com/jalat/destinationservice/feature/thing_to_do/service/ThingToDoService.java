package com.jalat.destinationservice.feature.thing_to_do.service;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.core.BaseEntityResponseDto;
import com.jalat.destinationservice.feature.thing_to_do.dto.request.ThingToDoRequest;
import com.jalat.destinationservice.feature.thing_to_do.dto.response.ThingToDoResponse;
import com.jalat.destinationservice.feature.thing_to_do.entity.ThingToDo;

import java.util.List;

public interface ThingToDoService {
    BaseResponse<ThingToDoResponse> createThingToDo(ThingToDoRequest thingToDoRequest);

    BaseResponse<List<ThingToDoResponse>> getAllThingToDo();
}
