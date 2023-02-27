package com.haidi.haidimasterdata.api.mappers;

import com.haidi.haidimasterdata.api.requests.SpecialtyRequest;
import com.haidi.haidimasterdata.domain.pojo.Specialty;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SpecialtyMapper {
    SpecialtyMapper INSTANCE = Mappers.getMapper(SpecialtyMapper.class);

    List<Specialty> toDomain(List<SpecialtyRequest> specialtyRequest);
}
