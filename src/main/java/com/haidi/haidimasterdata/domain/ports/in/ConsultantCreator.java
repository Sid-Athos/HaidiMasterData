package com.haidi.haidimasterdata.domain.ports.in;

import com.haidi.haidimasterdata.domain.pojo.CreateConsultantCommand;

public interface ConsultantCreator {
    Long saveConsultant(CreateConsultantCommand createConsultantCommand);
}
