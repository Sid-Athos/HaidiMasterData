package com.haidi.haidimasterdata.domain.ports.out;

import com.haidi.haidimasterdata.domain.pojo.Family;
import com.jnape.palatable.lambda.adt.Maybe;

import java.util.List;

public interface FamilyPersistencePort {

    Long save(Family family);

    void update(Family family);

    Maybe<Family> findByCode(String code);

    Maybe<Family> findById(Long id);

    List<Family> getAllFamiliesFromDb();
}
