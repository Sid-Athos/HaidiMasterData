package com.haidi.haidimasterdata.persistence.repositories;

import com.haidi.haidimasterdata.persistence.entities.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Locations, Long> {

    public Locations findByCode(String description);
}
