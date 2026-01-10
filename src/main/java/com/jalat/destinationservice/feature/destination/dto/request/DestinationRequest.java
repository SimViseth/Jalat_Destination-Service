package com.jalat.destinationservice.feature.destination.dto.request;

import com.jalat.destinationservice.enums.EnumDestinationType;
import com.jalat.destinationservice.enums.EnumProvince;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DestinationRequest {
    String destinationName;
    String destinationType;
    String image;
    String description;
    String village;
    String commune;
    String district;
    String province;
}
