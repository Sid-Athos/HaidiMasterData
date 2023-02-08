package com.haidi.haidimasterdata.persistence.adapters;

import com.haidi.haidimasterdata.domain.pojo.UnitOfMeasure;
import com.haidi.haidimasterdata.domain.ports.out.UomPersistencePort;
import com.jnape.palatable.lambda.adt.Maybe;

import java.util.List;

public class UomPersistenceSpi implements UomPersistencePort {
    @Override
    public Long save(UnitOfMeasure unitOfMeasure) {
        return null;
    }

    @Override
    public void update(UnitOfMeasure unitOfMeasure) {

    }

    @Override
    public Maybe<UnitOfMeasure> findByCode(String code) {
        return null;
    }

    @Override
    public Maybe<UnitOfMeasure> findById(Long id) {
        return null;
    }

    @Override
    public List<UnitOfMeasure> getAllProductsFromDb() {
        return null;
    }
}
