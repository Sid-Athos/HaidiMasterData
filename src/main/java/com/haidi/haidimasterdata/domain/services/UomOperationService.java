package com.haidi.haidimasterdata.domain.services;

import com.haidi.haidimasterdata.domain.pojo.UnitOfMeasure;
import com.haidi.haidimasterdata.domain.ports.in.UomServicePort;
import com.haidi.haidimasterdata.domain.ports.out.UomPersistencePort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UomOperationService implements UomServicePort {

    private static final Logger LOGGER = Logger.getLogger(UomOperationService.class.getName());

    private final UomPersistencePort uomPersistencePort;

    public UomOperationService(UomPersistencePort uomPersistencePort) {
        this.uomPersistencePort = uomPersistencePort;
    }

    @Override
    public Long addUnitOfMeasure(UnitOfMeasure uom) {
        return 1L;
    }

    @Override
    public void updateUnitOfMeasure(UnitOfMeasure uom) {

    }

    @Override
    public List<UnitOfMeasure> getAllUnitsOfMeasure() {
        return null;
    }
}
