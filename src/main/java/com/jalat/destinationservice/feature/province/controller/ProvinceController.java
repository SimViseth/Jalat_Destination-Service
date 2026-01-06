package com.jalat.destinationservice.feature.province.controller;

import com.jalat.destinationservice.feature.province.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/province")
@RequiredArgsConstructor
public class ProvinceController {

    private final ProvinceService provinceService;

}
