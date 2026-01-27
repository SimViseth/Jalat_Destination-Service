package com.jalat.destinationservice.feature.place_to_stay.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaceToStayRequest {
    String accommodationName;
    String type;
    String image;
    String description;
    String village;
    String commune;
    String district;
    String province;
    Integer destination;
}
