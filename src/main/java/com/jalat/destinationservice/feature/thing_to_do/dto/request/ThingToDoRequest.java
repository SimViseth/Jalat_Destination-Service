package com.jalat.destinationservice.feature.thing_to_do.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ThingToDoRequest {
    String title;
    String image;
    String description;
    String village;
    String commune;
    String district;
    String province;
    Integer destinationId;
}
