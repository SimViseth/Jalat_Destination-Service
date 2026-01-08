package com.jalat.destinationservice.feature.destination.dao;

import com.jalat.destinationservice.core.BaseDBDao;
import com.jalat.destinationservice.feature.destination.entity.Destination;
import com.jalat.destinationservice.feature.destination.repository.DestinationRepository;
import org.springframework.stereotype.Service;

@Service
public class DestinationDao extends BaseDBDao<Destination, Integer> {
    public DestinationDao(DestinationRepository destinationRepository) {
        super(destinationRepository);
    }
}
