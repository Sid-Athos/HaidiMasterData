package com.haidi.haidimasterdata.persistence.mappers;

import com.haidi.haidimasterdata.api.mappers.SpecialtyMapper;
import com.haidi.haidimasterdata.domain.pojo.CreateConsultantCommand;
import com.haidi.haidimasterdata.persistence.entities.ConsultantsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {SpecialtyMapper.class, AvailabilitiesMappers.class})
public interface ConsultantsMappers {
    ConsultantsMappers INSTANCE = Mappers.getMapper(ConsultantsMappers.class);

    ConsultantsEntity fromDomain(CreateConsultantCommand createConsultantCommand);

    CreateConsultantCommand toDomain(ConsultantsEntity consultantsEntity);

}
