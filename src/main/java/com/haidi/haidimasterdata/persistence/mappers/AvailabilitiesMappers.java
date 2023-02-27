package com.haidi.haidimasterdata.persistence.mappers;

import com.haidi.haidimasterdata.domain.pojo.Availability;
import com.haidi.haidimasterdata.persistence.entities.AvailabilitiesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AvailabilitiesMappers {
    AvailabilitiesMappers INSTANCE = Mappers.getMapper(AvailabilitiesMappers.class);

    List<AvailabilitiesEntity> fromDomain(List<Availability> availabilityList);

    List<Availability> toDomain(List<AvailabilitiesEntity> availabilityList);

}
