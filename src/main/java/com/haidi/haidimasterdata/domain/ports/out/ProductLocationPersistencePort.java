package com.haidi.haidimasterdata.domain.ports.out;

import com.haidi.haidimasterdata.domain.pojo.Location;
import com.haidi.haidimasterdata.domain.pojo.ProductLocation;
import com.jnape.palatable.lambda.adt.Maybe;

import java.util.List;

public interface ProductLocationPersistencePort {

    Long save(ProductLocation productLocation);


    Maybe<ProductLocation> findById(Long id);

    List<ProductLocation> getAllLocationsFromDb();

    void update(ProductLocation productLocation);
}
