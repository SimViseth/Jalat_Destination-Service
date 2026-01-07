package com.jalat.destinationservice.feature.province.service.serviceImpl;

import com.jalat.destinationservice.app.BaseResponse;
import com.jalat.destinationservice.core.BaseEntityResponseDto;
import com.jalat.destinationservice.feature.province.dao.ProvinceDao;
import com.jalat.destinationservice.feature.province.dto.request.ProvinceRequest;
import com.jalat.destinationservice.feature.province.dto.response.ProvinceResponse;
import com.jalat.destinationservice.feature.province.entity.Province;
import com.jalat.destinationservice.feature.province.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.jalat.destinationservice.app.AppConstant.SUCCESS;
import static com.jalat.destinationservice.app.AppConstant.SUCCESS_CODE;

@Service
@RequiredArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {

    private final ProvinceDao provinceDao;

    @Override
    public BaseResponse<ProvinceResponse> createProvince(ProvinceRequest provinceRequest) {

        // map request to entity
        Province province = new Province();
        province.setProvinceName(provinceRequest.getProvinceName());
        province.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        province.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        // save call dao
        BaseEntityResponseDto<Province> daoResponse = provinceDao.saveEntity(province);

        // map entity to response
        ProvinceResponse provinceResponse = ProvinceResponse.builder()
                .provinceId(daoResponse.getEntity().getProvinceId())
                .provinceName(daoResponse.getEntity().getProvinceName())
                .createdAt(daoResponse.getEntity().getCreatedAt())
                .build();

        // API response
        BaseResponse<ProvinceResponse> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Create province success.");
        baseResponse.setData(provinceResponse);

        return baseResponse;
    }

    @Override
    public BaseResponse<List<ProvinceResponse>> getAllProvince() {

        /* get all has only map entity to response directly because there is no request like post */

        // select all from entity
        BaseEntityResponseDto<Province> daoResponse = provinceDao.findAll();

        List<ProvinceResponse> provinceResponseList = new ArrayList<>();

        // daoResponse.getEntityList contains data that select from entity
        for (Province province : daoResponse.getEntityList()) {

            ProvinceResponse provinceResponse = ProvinceResponse.builder()  // map entity to response
                    .provinceId(province.getProvinceId())
                    .provinceName(province.getProvinceName())
                    .createdAt(province.getCreatedAt())
                    .build();
            provinceResponseList.add(provinceResponse);
        }

        BaseResponse<List<ProvinceResponse>> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Get all provinces success.");
        baseResponse.setData(provinceResponseList);
        return baseResponse;
    }

    @Override
    public BaseResponse<ProvinceResponse> getProvinceById(Integer provinceId) {

        BaseEntityResponseDto<Province> daoResponse = provinceDao.findById(provinceId);

        Province province = daoResponse.getEntity();

        // map entity to response
        ProvinceResponse provinceResponse = ProvinceResponse.builder()
                .provinceId(province.getProvinceId())
                .provinceName(province.getProvinceName())
                .createdAt(province.getCreatedAt())
                .build();

        BaseResponse<ProvinceResponse> baseResponse = new BaseResponse<>();
        baseResponse.setCode(SUCCESS_CODE);
        baseResponse.setStatus(SUCCESS);
        baseResponse.setMsg("Get province by Id success.");
        baseResponse.setData(provinceResponse);
        return baseResponse;
    }
}
