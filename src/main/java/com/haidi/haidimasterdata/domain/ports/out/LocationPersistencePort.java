package com.haidi.haidimasterdata.domain.ports.out;

import com.haidi.haidimasterdata.domain.pojo.Location;
import com.haidi.haidimasterdata.domain.pojo.Product;
import com.jnape.palatable.lambda.adt.Maybe;

import java.util.List;

public interface LocationPersistencePort {
    Long save(Location product);

    Maybe<Location> findByCode(String code);

    Maybe<Location> findById(Long id);

    List<Location> getAllLocationsFromDb();

    void update(Location locationFromDb);
}
