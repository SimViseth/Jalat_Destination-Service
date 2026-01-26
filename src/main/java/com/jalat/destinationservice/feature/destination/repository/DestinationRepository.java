package com.jalat.destinationservice.feature.destination.repository;

import com.jalat.destinationservice.core.IBaseRepository;
import com.jalat.destinationservice.feature.destination.dto.response.DestinationResponse;
import com.jalat.destinationservice.feature.destination.entity.Destination;

public interface DestinationRepository extends IBaseRepository<Destination, Integer> {
    DestinationResponse findDestinationByDestinationNameLike(String name);
}
