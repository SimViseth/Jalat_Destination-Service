package com.jalat.destinationservice.feature.thing_to_do;

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
@Table(name = "thing_to_do")
public class ThingToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ttdId;

    String title;
    String description;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    Destination destination;
}
