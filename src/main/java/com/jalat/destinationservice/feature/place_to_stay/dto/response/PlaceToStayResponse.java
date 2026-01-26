package com.jalat.destinationservice.feature.place_to_stay.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PlaceToStayResponse {
    Integer stayId;

    String accommodationName;
    String type;
    String image;
    String description;
    String village;
    String commune;
    String district;
    String province;
}
