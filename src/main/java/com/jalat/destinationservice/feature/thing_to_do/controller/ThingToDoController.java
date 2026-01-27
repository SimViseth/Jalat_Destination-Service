package com.jalat.destinationservice.feature.thing_to_do.controller;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.core.BaseEntityResponseDto;
import com.jalat.destinationservice.feature.thing_to_do.dto.request.ThingToDoRequest;
import com.jalat.destinationservice.feature.thing_to_do.dto.response.ThingToDoResponse;
import com.jalat.destinationservice.feature.thing_to_do.entity.ThingToDo;
import com.jalat.destinationservice.feature.thing_to_do.service.ThingToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/thing-to-do")
@RequiredArgsConstructor
public class ThingToDoController {

    private final ThingToDoService thingToDoService;

    @PostMapping
    public BaseResponse<ThingToDoResponse> createThingToDo(@RequestBody ThingToDoRequest thingToDoRequest) {
        return thingToDoService.createThingToDo(thingToDoRequest);
    }
}
