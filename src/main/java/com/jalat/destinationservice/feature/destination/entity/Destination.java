package com.jalat.destinationservice.feature.destination.entity;

import com.jalat.destinationservice.feature.province.entity.Province;
import com.jalat.destinationservice.feature.thing_to_do.ThingToDo;
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
    String village;
    String commune;
    String district;
    String province;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ThingToDo> thingToDoList;
}
