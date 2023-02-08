package com.haidi.haidimasterdata.domain.services;

import com.haidi.haidimasterdata.domain.pojo.Family;
import com.haidi.haidimasterdata.domain.ports.in.FamilyServicePort;
import com.haidi.haidimasterdata.domain.ports.out.FamilyPersistencePort;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FamiliesOperationService implements FamilyServicePort {
    private static final Logger LOGGER = Logger.getLogger(FamiliesOperationService.class.getName());

    private final FamilyPersistencePort familyPersistencePort;

    public FamiliesOperationService(FamilyPersistencePort familyPersistencePort) {
        this.familyPersistencePort = familyPersistencePort;
    }

    @Override
    public Long addFamily(Family family) {
        LOGGER.log(Level.INFO, "Saving new family "  + family);
        var maybeFamily = familyPersistencePort.findByCode(family.getDescription());
        var result = maybeFamily.orElseGet(() -> {
            final var itemId =  familyPersistencePort.save(family);
            family.setId(itemId);
            return family;
        });
        LOGGER.log(Level.INFO, "Family saved with ID  "  + family.getId());
        return result.getId();
    }

    @Override
    public void updateFamily(Family family) {
        LOGGER.log(Level.INFO, "Updating family "  + family);
        familyPersistencePort.findById(family.getId())
                .fmap(familyFromDb -> {
                    LOGGER.log(Level.INFO, "Family in db found "  + familyFromDb);
                    familyPersistencePort.update(family);
                    return family;
                }).orElseThrow(() -> {
                    throw new RuntimeException();
                });
        LOGGER.log(Level.INFO, "Family updated ");
    }

    @Override
    public List<Family> getAllFamilies() {
        return familyPersistencePort.getAllFamiliesFromDb();
    }
}
