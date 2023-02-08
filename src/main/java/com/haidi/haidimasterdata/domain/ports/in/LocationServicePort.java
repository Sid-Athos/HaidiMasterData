package com.haidi.haidimasterdata.domain.ports.in;

import com.haidi.haidimasterdata.domain.pojo.Location;

import java.util.List;

public interface LocationServicePort {
    Long addLocation(Location location);

    void updateLocation(Location location);

    List<Location> getAllLocations();
}
