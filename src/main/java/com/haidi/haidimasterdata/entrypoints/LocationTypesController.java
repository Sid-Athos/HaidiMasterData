package com.haidi.haidimasterdata.entrypoints;


import com.haidi.haidimasterdata.api.requests.locationtypes.CreateLocationTypeRequest;
import com.haidi.haidimasterdata.api.requests.locationtypes.UpdateLocationTypeRequest;
import com.haidi.haidimasterdata.domain.pojo.LocationType;
import com.haidi.haidimasterdata.domain.ports.in.LocationTypeServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locationTypes")
public class LocationTypesController {
    private final LocationTypeServicePort locationTypeServicePort;

    @Autowired
    public LocationTypesController(LocationTypeServicePort locationTypeServicePort) {
        this.locationTypeServicePort = locationTypeServicePort;
    }

    @PostMapping(value = "/createLocationType", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long createLocationType(@RequestBody CreateLocationTypeRequest locationTypeRequest){
        final var locationTypeToCreate = LocationType.createLocationType(
                locationTypeRequest.description);
        return locationTypeServicePort.addLocationType(locationTypeToCreate);
    }

    @PutMapping(value = "/updateLocationType", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateProduct(@RequestBody UpdateLocationTypeRequest updateLocationTypeRequest){
        final var locationTypeToUpdate = LocationType.createLocationTypeToUpdate(
                updateLocationTypeRequest.id,
                updateLocationTypeRequest.description);
        locationTypeServicePort.updateLocationType(locationTypeToUpdate);
    }

    @GetMapping(value = "/findAllLocationTypes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LocationType> findAllProducts(){
        return locationTypeServicePort.getAllLocationType();
    }

}
