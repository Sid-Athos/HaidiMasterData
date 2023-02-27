package com.haidi.haidimasterdata.api.mappers;

import com.haidi.haidimasterdata.api.requests.AvailabilityRequest;
import com.haidi.haidimasterdata.domain.pojo.Availability;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AvailabilityMapper {
    AvailabilityMapper INSTANCE = Mappers.getMapper(AvailabilityMapper.class);

    List<Availability> toDomain(List<AvailabilityRequest> availabilityRequest);

}
