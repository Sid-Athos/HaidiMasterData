package com.haidi.haidimasterdata.persistence.repositories;

import com.haidi.haidimasterdata.persistence.entities.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, Long> {

    public ProductsEntity findByCode(String code);

}
