package com.haidi.haidimasterdata.domain.services;

import com.haidi.haidimasterdata.domain.pojo.Location;
import com.haidi.haidimasterdata.domain.ports.in.LocationServicePort;
import com.haidi.haidimasterdata.domain.ports.out.LocationPersistencePort;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocationsOperationService implements LocationServicePort {

    private static final Logger LOGGER = Logger.getLogger(FamiliesOperationService.class.getName());

    private final LocationPersistencePort locationPersistencePort;

    public LocationsOperationService(LocationPersistencePort locationPersistencePort) {
        this.locationPersistencePort = locationPersistencePort;
    }

    @Override
    public Long addLocation(Location location) {
        LOGGER.log(Level.INFO, "Saving new location "  + location);
        var maybeLocation = locationPersistencePort.findByCode(location.getCode());
        var result = maybeLocation.orElseGet(() -> {
            final var itemId =  locationPersistencePort.save(location);
            location.setId(itemId);
            return location;
        });
        LOGGER.log(Level.INFO, "Location saved with ID  "  + location.getId());
        return result.getId();
    }

    @Override
    public void updateLocation(Location location) {
        LOGGER.log(Level.INFO, "Updating location "  + location);
        locationPersistencePort.findById(location.getId())
                .fmap(locationFromDb -> {
                    LOGGER.log(Level.INFO, "Location in db found "  + locationFromDb);
                    locationPersistencePort.update(location);
                    return location;
                }).orElseThrow(() -> {
                    throw new RuntimeException();
                });
        LOGGER.log(Level.INFO, "Family updated ");
    }

    @Override
    public List<Location> getAllLocations() {
        return locationPersistencePort.getAllLocationsFromDb();
    }
}
