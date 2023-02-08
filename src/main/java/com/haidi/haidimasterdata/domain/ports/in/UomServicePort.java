package com.haidi.haidimasterdata.domain.ports.in;

import com.haidi.haidimasterdata.domain.pojo.UnitOfMeasure;

import java.util.List;

public interface UomServicePort {
    Long addUnitOfMeasure(UnitOfMeasure uom);

    void updateUnitOfMeasure(UnitOfMeasure uom);

    List<UnitOfMeasure> getAllUnitsOfMeasure();
}
