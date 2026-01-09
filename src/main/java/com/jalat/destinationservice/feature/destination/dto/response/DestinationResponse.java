package com.jalat.destinationservice.feature.destination.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DestinationResponse {
    Integer destinationId;
    String destinationName;
    String destinationType;
    String image;
    String description;
    String village;
    String commune;
    String district;
    String province;
}
