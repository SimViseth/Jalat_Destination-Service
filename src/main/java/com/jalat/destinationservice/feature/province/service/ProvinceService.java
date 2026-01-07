package com.jalat.destinationservice.feature.province.service;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.feature.province.dto.request.ProvinceRequest;
import com.jalat.destinationservice.feature.province.dto.response.ProvinceResponse;

import java.util.List;

public interface ProvinceService {
    BaseResponse<ProvinceResponse> createProvince(ProvinceRequest provinceRequest);

    BaseResponse<List<ProvinceResponse>> getAllProvince();

    BaseResponse<ProvinceResponse> getProvinceById(Integer provinceId);

    BaseResponse<ProvinceResponse> updateProvince(Integer provinceId, ProvinceRequest provinceRequest);
}
