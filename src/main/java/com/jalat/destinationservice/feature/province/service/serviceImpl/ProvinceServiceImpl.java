package com.jalat.destinationservice.feature.province.service.serviceImpl;

import com.jalat.destinationservice.feature.province.repository.ProvinceRepository;
import com.jalat.destinationservice.feature.province.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {

    private final ProvinceRepository provinceRepository;
}
