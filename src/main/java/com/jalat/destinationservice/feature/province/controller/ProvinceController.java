package com.jalat.destinationservice.feature.province.controller;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.feature.province.dto.request.ProvinceRequest;
import com.jalat.destinationservice.feature.province.dto.response.ProvinceResponse;
import com.jalat.destinationservice.feature.province.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/province")
@RequiredArgsConstructor
public class ProvinceController {

    private final ProvinceService provinceService;

    @PostMapping("/create")
    public BaseResponse<ProvinceResponse> createProvince(@RequestBody ProvinceRequest provinceRequest) {
        BaseResponse<ProvinceResponse> provinceResponse = provinceService.createProvince(provinceRequest);
        return provinceResponse;
    }

    @GetMapping("/getAll")
    public BaseResponse<List<ProvinceResponse>> getAllProvinces() {
        BaseResponse<List<ProvinceResponse>> provinceResponse = provinceService.getAllProvince();
        return provinceResponse;
    }

    @GetMapping("/getById/{provinceId}")
    public BaseResponse<ProvinceResponse> getProvinceById(@PathVariable Integer provinceId) {
        BaseResponse<ProvinceResponse> provinceResponse = provinceService.getProvinceById(provinceId);
        return provinceResponse;
    }

    @PutMapping("/update/{provinceId}")
    public BaseResponse<ProvinceResponse> createProvince(@PathVariable Integer provinceId, @RequestBody ProvinceRequest provinceRequest) {
        BaseResponse<ProvinceResponse> provinceResponse = provinceService.updateProvince(provinceId, provinceRequest);
        return provinceResponse;
    }

    @DeleteMapping("/delete/{provinceId}")
    public BaseResponse<Void> deleteProvince(@PathVariable Integer provinceId) {
        return provinceService.deleteProvince(provinceId);
    }
}
