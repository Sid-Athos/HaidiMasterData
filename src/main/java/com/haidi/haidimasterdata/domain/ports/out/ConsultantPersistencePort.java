package com.haidi.haidimasterdata.domain.ports.out;

import com.haidi.haidimasterdata.domain.pojo.CreateConsultantCommand;

public interface ConsultantPersistencePort {
    Long saveConsultant(CreateConsultantCommand createConsultantCommand);

}
