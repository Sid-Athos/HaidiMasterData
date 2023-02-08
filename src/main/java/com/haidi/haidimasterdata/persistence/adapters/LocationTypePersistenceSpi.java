package com.haidi.haidimasterdata.persistence.adapters;

import com.haidi.haidimasterdata.domain.pojo.LocationType;
import com.haidi.haidimasterdata.domain.ports.out.LocationTypePersistencePort;
import com.haidi.haidimasterdata.persistence.repositories.LocationTypeRepository;
import com.jnape.palatable.lambda.adt.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LocationTypePersistenceSpi implements LocationTypePersistencePort {

    private final LocationTypeRepository locationTypeRepository;

    @Autowired
    public LocationTypePersistenceSpi(LocationTypeRepository locationTypeRepository) {
        this.locationTypeRepository = locationTypeRepository;
    }

    @Override
    public Long save(LocationType locationType) {
        com.haidi.haidimasterdata.persistence.entities.LocationType toSave = new com.haidi.haidimasterdata.persistence.entities.LocationType();
        toSave.setDescription(locationType.getDescription());
        return locationTypeRepository.save(toSave).getId();
    }

    @Override
    public void update(LocationType locationType) {
        com.haidi.haidimasterdata.persistence.entities.LocationType toSave = new com.haidi.haidimasterdata.persistence.entities.LocationType();
        toSave.setDescription(locationType.getDescription());
        toSave.setId(locationType.getId());
        locationTypeRepository.save(toSave);
    }


    @Override
    public Maybe<LocationType> findById(Long id) {
        final var toReturn = locationTypeRepository.findById(id);
        if(toReturn.isPresent()){
            var found = toReturn.get();
            LocationType foundLocationType = LocationType.createLocationTypeToUpdate(found.getId(), found.getDescription());
            return Maybe.maybe(foundLocationType);
        }
        return Maybe.nothing();
    }

    @Override
    public Maybe<LocationType> findByDescription(String description) {
        final var toReturn = locationTypeRepository.findByDescription(description);
        if(toReturn != null){
            LocationType foundLocationType = LocationType.createLocationTypeToUpdate(toReturn.getId(), toReturn.getDescription());
            return Maybe.maybe(foundLocationType);
        }
        return Maybe.nothing();
    }

    @Override
    public List<LocationType> getAllLocationTypesFromDb() {
         return locationTypeRepository
                .findAll()
                .stream()
                .map(item -> LocationType.createLocationTypeToUpdate(
                        item.getId(),
                        item.getDescription()))
                .collect(Collectors.toList());
    }
}
