package com.haidi.haidimasterdata.domain.ports.out;

import com.haidi.haidimasterdata.domain.pojo.Product;
import com.haidi.haidimasterdata.domain.pojo.UnitOfMeasure;
import com.jnape.palatable.lambda.adt.Maybe;

import java.util.List;

public interface UomPersistencePort {
    Long save(UnitOfMeasure product);

    void update(UnitOfMeasure product);

    Maybe<UnitOfMeasure> findByCode(String code);

    Maybe<UnitOfMeasure> findById(Long id);

    List<UnitOfMeasure> getAllProductsFromDb();
}
