package com.haidi.haidimasterdata.domain.ports.out;

import com.haidi.haidimasterdata.domain.pojo.Product;
import com.jnape.palatable.lambda.adt.Maybe;

import java.util.List;

public interface ProductPersistencePort {
    Long save(Product product);

    void update(Product product);

    Maybe<Product> findByCode(String code);

    Maybe<Product> findById(Long id);

    List<Product> getAllProductsFromDb();
}
