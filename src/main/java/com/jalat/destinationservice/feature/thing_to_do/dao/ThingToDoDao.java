package com.jalat.destinationservice.feature.thing_to_do.dao;

import com.jalat.destinationservice.core.BaseDBDao;
import com.jalat.destinationservice.feature.thing_to_do.entity.ThingToDo;
import com.jalat.destinationservice.feature.thing_to_do.repository.ThingToDoRepository;
import org.springframework.stereotype.Service;

@Service
public class ThingToDoDao extends BaseDBDao<ThingToDo, Integer> {
    public ThingToDoDao(ThingToDoRepository thingToDoRepository) {
        super(thingToDoRepository);
    }
}
