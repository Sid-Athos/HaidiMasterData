package com.haidi.haidimasterdata.domain.services;

import com.haidi.haidimasterdata.domain.pojo.AvailableDays;
import com.haidi.haidimasterdata.domain.pojo.CreateConsultantCommand;
import com.haidi.haidimasterdata.domain.ports.in.ConsultantCreator;
import com.haidi.haidimasterdata.domain.ports.out.ConsultantPersistencePort;
import org.springframework.util.CollectionUtils;

public class ConsultantCreatorService implements ConsultantCreator {

    private final ConsultantPersistencePort consultantPersistencePort;

    public ConsultantCreatorService(ConsultantPersistencePort consultantPersistencePort) {
        this.consultantPersistencePort = consultantPersistencePort;
    }

    @Override
    public Long saveConsultant(CreateConsultantCommand createConsultantCommand) {
        consultantRules(createConsultantCommand);
        return consultantPersistencePort.saveConsultant(createConsultantCommand);
    }

    private void consultantRules(CreateConsultantCommand createConsultantCommand) {
        if(CollectionUtils.isEmpty(createConsultantCommand.getAvailabilities())){
            throw new RuntimeException("A minimum of one day availability is required");
        }
        if(CollectionUtils.isEmpty(createConsultantCommand.getSpecialty())){
            throw new RuntimeException("A minimum of one specialty is required");
        }
        if(createConsultantCommand.getDailyRate() < 100){
            throw new RuntimeException("People have to be paid somewhat sir");
        }
        createConsultantCommand.getAvailabilities().stream()
                .peek(availability -> {
                   if(!AvailableDays.checkEnumValue(availability.getDay().name())){
                       throw new RuntimeException("Illegal availability");
                   }
                }).close();
    }
}
