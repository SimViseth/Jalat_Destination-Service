package com.jalat.destinationservice.feature.place_to_stay;

import com.jalat.destinationservice.feature.destination.entity.Destination;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "place_to_stay")
public class PlaceToStay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer stayId;

    String accommodationName;
    String type;
    String image;
    String description;
    String village;
    String commune;
    String district;
    String province;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    Destination destination;
}
