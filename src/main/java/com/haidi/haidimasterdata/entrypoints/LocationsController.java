package com.haidi.haidimasterdata.entrypoints;

import com.haidi.haidimasterdata.api.requests.locations.CreateLocationRequest;
import com.haidi.haidimasterdata.api.requests.locations.UpdateLocationRequest;
import com.haidi.haidimasterdata.domain.pojo.Location;
import com.haidi.haidimasterdata.domain.ports.in.LocationServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")

public class LocationsController {

    private final LocationServicePort locationServicePort;

    @Autowired
    public LocationsController(LocationServicePort locationServicePort) {
        this.locationServicePort = locationServicePort;
    }

    @PostMapping(value = "/createLocation", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long createLocation(@RequestBody CreateLocationRequest locationRequest){
        final var locationToCreate = Location.createLocation(
                locationRequest.code,
                locationRequest.street,
                locationRequest.city ,
                locationRequest.zipCode,
                locationRequest.country ,
                locationRequest.description ,
                locationRequest.locationType ,
                locationRequest.channel);
        return locationServicePort.addLocation(locationToCreate);
    }

    @PutMapping(value = "/updateLocation", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateLocation(@RequestBody UpdateLocationRequest updateLocationRequest){
        final var locationToUpdate = Location.createLocationWithId(
                updateLocationRequest.id,
                updateLocationRequest.code,
                updateLocationRequest.street,
                updateLocationRequest.city ,
                updateLocationRequest.zipCode,
                updateLocationRequest.country ,
                updateLocationRequest.description ,
                updateLocationRequest.locationType ,
                updateLocationRequest.channel);
        locationServicePort.updateLocation(locationToUpdate);
    }

    @GetMapping(value = "/findLocations", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Location> findAllLocations(){
        return locationServicePort.getAllLocations();
    }
}
