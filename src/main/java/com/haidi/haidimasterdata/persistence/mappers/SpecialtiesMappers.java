package com.haidi.haidimasterdata.persistence.mappers;

import com.haidi.haidimasterdata.domain.pojo.Availability;
import com.haidi.haidimasterdata.domain.pojo.Specialty;
import com.haidi.haidimasterdata.persistence.entities.AvailabilitiesEntity;
import com.haidi.haidimasterdata.persistence.entities.SpecialtiesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper

public interface SpecialtiesMappers {

    SpecialtiesMappers INSTANCE = Mappers.getMapper(SpecialtiesMappers.class);

    List<SpecialtiesEntity> fromDomain(List<Specialty> availabilityList);

    List<Specialty> toDomain(List<SpecialtiesEntity> availabilityList);
}
