package com.haidi.haidimasterdata.domain.ports.out;

import com.haidi.haidimasterdata.domain.pojo.Family;
import com.haidi.haidimasterdata.domain.pojo.LocationType;
import com.jnape.palatable.lambda.adt.Maybe;

import java.util.List;

public interface LocationTypePersistencePort {
    Long save(LocationType family);

    void update(LocationType family);


    Maybe<LocationType> findById(Long id);

    Maybe<LocationType> findByDescription(String description);


    List<LocationType> getAllLocationTypesFromDb();
}
