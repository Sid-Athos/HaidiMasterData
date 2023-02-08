package com.haidi.haidimasterdata.domain.ports.in;

import com.haidi.haidimasterdata.domain.pojo.Family;
import com.haidi.haidimasterdata.domain.pojo.Location;

import java.util.List;

public interface FamilyServicePort {
    Long addFamily(Family family);

    void updateFamily(Family family);

    List<Family> getAllFamilies();
}
