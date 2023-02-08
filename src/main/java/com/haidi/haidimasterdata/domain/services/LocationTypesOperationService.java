package com.haidi.haidimasterdata.domain.services;

import com.haidi.haidimasterdata.domain.errors.HaidiException;
import com.haidi.haidimasterdata.domain.errors.HaidiExceptionEnum;
import com.haidi.haidimasterdata.domain.pojo.LocationType;
import com.haidi.haidimasterdata.domain.ports.in.LocationTypeServicePort;
import com.haidi.haidimasterdata.domain.ports.out.LocationTypePersistencePort;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocationTypesOperationService implements LocationTypeServicePort {

    private static final Logger LOGGER = Logger.getLogger(LocationTypesOperationService.class.getName());

    private  final LocationTypePersistencePort locationTypePersistencePort;

    public LocationTypesOperationService(LocationTypePersistencePort locationTypePersistencePort) {
        this.locationTypePersistencePort = locationTypePersistencePort;
    }

    @Override
    public Long addLocationType(LocationType locationType) {
        LOGGER.log(Level.INFO, "Saving new location type "  + locationType);
        var maybeLocationType = locationTypePersistencePort.findByDescription(locationType.getDescription());
        var result = maybeLocationType.orElseGet(() -> {
            final var itemId =  locationTypePersistencePort.save(locationType);
            locationType.setId(itemId);
            return locationType;
        });
        LOGGER.log(Level.INFO, "Location type saved with ID  "  + locationType.getId());
        return result.getId();
    }

    @Override
    public void updateLocationType(LocationType locationType) {
        LOGGER.log(Level.INFO, "Updating location type "  + locationType);
        locationTypePersistencePort.findById(locationType.getId())
                .fmap(familyFromDb -> {
                    LOGGER.log(Level.INFO, "LocationType in db found "  + familyFromDb);
                    locationTypePersistencePort.update(locationType);
                    return locationType;
                }).orElseThrow(() -> {
                    LOGGER.log(Level.INFO, "Tried to find unexisting item with id "  + locationType.getId());

                    throw new HaidiException(HaidiExceptionEnum.DOMAIN_COMPONENT_ITEM_NOT_FOUND);
                });
        LOGGER.log(Level.INFO, "LocationType updated ");
    }

    @Override
    public List<LocationType> getAllLocationType() {
        return locationTypePersistencePort.getAllLocationTypesFromDb();
    }
}
