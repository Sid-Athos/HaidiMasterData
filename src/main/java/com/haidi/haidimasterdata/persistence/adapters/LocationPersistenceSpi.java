package com.haidi.haidimasterdata.persistence.adapters;

import com.haidi.haidimasterdata.domain.pojo.Location;
import com.haidi.haidimasterdata.domain.ports.out.LocationPersistencePort;
import com.haidi.haidimasterdata.persistence.entities.LocationType;
import com.haidi.haidimasterdata.persistence.entities.Locations;
import com.haidi.haidimasterdata.persistence.repositories.LocationRepository;
import com.haidi.haidimasterdata.persistence.repositories.LocationTypeRepository;
import com.jnape.palatable.lambda.adt.Maybe;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LocationPersistenceSpi implements LocationPersistencePort {

    private final LocationTypeRepository locationTypeRepository;

    private final LocationRepository locationRepository;

    public LocationPersistenceSpi(LocationTypeRepository locationTypeRepository, LocationRepository locationRepository) {
        this.locationTypeRepository = locationTypeRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public Long save(Location location) {
        Locations toSave = new Locations();
        LocationType locationTypeToLink = locationTypeRepository.findById(location.getLocationType()).orElseThrow(
                RuntimeException::new
        );
        setLocationNewData(location, toSave, locationTypeToLink);
        return locationRepository.save(toSave).getId();
    }

    @Override
    public void update(Location locationToUpdate) {
        Locations toSave = new Locations();
        LocationType locationTypeToLink = locationTypeRepository.findById(locationToUpdate.getLocationType()).orElseThrow(
                RuntimeException::new
        );
        toSave.setId(locationToUpdate.getId());
        setLocationNewData(locationToUpdate, toSave, locationTypeToLink);
        locationRepository.save(toSave);
    }

    private void setLocationNewData(Location locationFromDb, Locations toSave, LocationType locationTypeToLink) {
        toSave.setChannel(locationFromDb.getChannel());
        toSave.setCode(locationFromDb.getCode());
        toSave.setDescription(locationFromDb.getDescription());
        toSave.setStreet(locationFromDb.getStreet());
        toSave.setZipCode(locationFromDb.getZipCode());
        toSave.setCity(locationFromDb.getCity());
        toSave.setCountry(locationFromDb.getCountry());
        toSave.setLocationType(locationTypeToLink);
    }

    @Override
    public Maybe<Location> findByCode(String code) {
        final var toReturn = locationRepository.findByCode(code);
        if(toReturn != null ){
            Location foundLocation = Location.createLocationWithId(
                    toReturn.getId(),
                    toReturn.getCode(),
                    toReturn.getStreet(),
                    toReturn.getCity(),
                    toReturn.getZipCode(),
                    toReturn.getCountry(),
                    toReturn.getDescription(),
                    toReturn.getLocationType().getId(),
                    toReturn.getChannel());
            return Maybe.maybe(foundLocation);
        }
        return Maybe.nothing();
    }

    @Override
    public Maybe<Location> findById(Long id) {
        final var toReturn = locationRepository.findById(id);
        if(toReturn.isPresent()){
            var found = toReturn.get();
            Location foundLocation = Location.createLocationWithId(
                    found.getId(),
                    found.getCode(),
                    found.getStreet(),
                    found.getCity(),
                    found.getZipCode(),
                    found.getCountry(),
                    found.getDescription(),
                    found.getLocationType().getId(),
                    found.getChannel());
            return Maybe.maybe(foundLocation);

        }
        return Maybe.nothing();
    }

    @Override
    public List<Location> getAllLocationsFromDb() {
        return locationRepository
                .findAll()
                .stream()
                .map(item -> Location.createLocationWithId(
                        item.getId(),
                                item.getCode(),
                                item.getStreet(),
                                item.getCity(),
                                item.getZipCode(),
                                item.getCountry(),
                                item.getDescription(),
                                item.getLocationType().getId(),
                                item.getChannel()))
                .collect(Collectors.toList());
    }


}
