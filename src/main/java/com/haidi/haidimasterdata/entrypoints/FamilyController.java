package com.haidi.haidimasterdata.entrypoints;

import com.haidi.haidimasterdata.api.requests.families.CreateFamilyRequest;
import com.haidi.haidimasterdata.api.requests.families.UpdateFamilyRequest;
import com.haidi.haidimasterdata.domain.pojo.Family;
import com.haidi.haidimasterdata.domain.ports.in.FamilyServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/families")
public class FamilyController {

    private final FamilyServicePort familyServicePort;

    @Autowired
    public FamilyController(FamilyServicePort familyServicePort) {
        this.familyServicePort = familyServicePort;
    }

    @PostMapping(value = "/createFamily", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long createFamily(@RequestBody CreateFamilyRequest familyRequest){
        final var familyToCreate = Family.createFamily(
                familyRequest.description,
                familyRequest.parentId);
        return familyServicePort.addFamily(familyToCreate);
    }

    @PutMapping(value = "/updateFamily", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateFamily(@RequestBody UpdateFamilyRequest updateFamilyRequest){
        final var familyToUpdate = Family.createFamilyToUpdate(
                updateFamilyRequest.id,
                updateFamilyRequest.description,
                updateFamilyRequest.parentId);
        familyServicePort.updateFamily(familyToUpdate);
    }

    @GetMapping(value = "/findFamilies", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Family> findAllProducts(){
        return familyServicePort.getAllFamilies();
    }
}
