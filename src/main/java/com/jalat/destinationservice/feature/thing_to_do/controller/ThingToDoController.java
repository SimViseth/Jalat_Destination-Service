package com.jalat.destinationservice.feature.thing_to_do.controller;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.core.BaseEntityResponseDto;
import com.jalat.destinationservice.feature.thing_to_do.dto.request.ThingToDoRequest;
import com.jalat.destinationservice.feature.thing_to_do.dto.response.ThingToDoResponse;
import com.jalat.destinationservice.feature.thing_to_do.entity.ThingToDo;
import com.jalat.destinationservice.feature.thing_to_do.service.ThingToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/thing-to-do")
@RequiredArgsConstructor
public class ThingToDoController {

    private final ThingToDoService thingToDoService;

    @PostMapping("/create")
    public BaseResponse<ThingToDoResponse> createThingToDo(@RequestBody ThingToDoRequest thingToDoRequest) {
        return thingToDoService.createThingToDo(thingToDoRequest);
    }

    @GetMapping
    public BaseResponse<List<ThingToDoResponse>> getAllThingToDo() {
        return thingToDoService.getAllThingToDo();
    }
}
