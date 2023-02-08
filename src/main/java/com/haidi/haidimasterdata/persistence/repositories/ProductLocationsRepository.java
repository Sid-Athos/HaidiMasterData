package com.haidi.haidimasterdata.persistence.repositories;

import com.haidi.haidimasterdata.persistence.entities.ProductLocationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLocationsRepository extends JpaRepository<ProductLocationsEntity, Long> {
}
