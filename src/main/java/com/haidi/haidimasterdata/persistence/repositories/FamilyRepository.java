package com.haidi.haidimasterdata.persistence.repositories;

import com.haidi.haidimasterdata.persistence.entities.HaidiFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends JpaRepository<HaidiFamily, Long> {
    public HaidiFamily findByDescription(String description);
}
