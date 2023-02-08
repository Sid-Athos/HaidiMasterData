package com.haidi.haidimasterdata.domain.ports.in;

import com.haidi.haidimasterdata.domain.pojo.LocationType;

import java.util.List;

public interface LocationTypeServicePort {
    Long addLocationType(LocationType locationType);

    void updateLocationType(LocationType locationType);

    List<LocationType> getAllLocationType();
}
