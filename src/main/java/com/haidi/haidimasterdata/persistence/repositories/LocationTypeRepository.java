package com.haidi.haidimasterdata.persistence.repositories;

import com.haidi.haidimasterdata.persistence.entities.LocationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationTypeRepository extends JpaRepository<LocationType, Long> {
    public LocationType findByDescription(String description);

}
