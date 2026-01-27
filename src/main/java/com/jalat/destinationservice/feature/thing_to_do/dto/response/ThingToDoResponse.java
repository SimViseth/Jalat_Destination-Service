package com.jalat.destinationservice.feature.thing_to_do.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ThingToDoResponse {
    Integer ttdId;
    String title;
    String image;
    String description;
    String village;
    String commune;
    String district;
    String province;
    Integer destinationId;
}
