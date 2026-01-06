package com.jalat.destinationservice.feature.province.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProvinceResponse {
    Integer provinceId;
    String provinceName;
    LocalDateTime createdAt;
}
