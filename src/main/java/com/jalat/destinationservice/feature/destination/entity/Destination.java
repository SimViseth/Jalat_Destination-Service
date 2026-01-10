package com.jalat.destinationservice.feature.destination.entity;

import com.jalat.destinationservice.enums.EnumDestinationType;
import com.jalat.destinationservice.enums.EnumProvince;
import com.jalat.destinationservice.feature.place_to_eat.entity.PlaceToEat;
import com.jalat.destinationservice.feature.place_to_stay.PlaceToStay;
import com.jalat.destinationservice.feature.thing_to_do.entity.ThingToDo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "destination")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer destinationId;

    String destinationName;
    String destinationType;
    String image;
    String description;
    String village;
    String commune;
    String district;
    String province;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ThingToDo> thingToDoList;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PlaceToEat> placeToEatList;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PlaceToStay> placeToStayList;
}
