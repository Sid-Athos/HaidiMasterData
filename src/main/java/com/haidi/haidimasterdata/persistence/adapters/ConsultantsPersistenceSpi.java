package com.haidi.haidimasterdata.persistence.adapters;

import com.haidi.haidimasterdata.domain.pojo.CreateConsultantCommand;
import com.haidi.haidimasterdata.domain.ports.out.ConsultantPersistencePort;
import com.haidi.haidimasterdata.persistence.mappers.ConsultantsMappers;
import com.haidi.haidimasterdata.persistence.repositories.ConsultantRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ConsultantsPersistenceSpi implements ConsultantPersistencePort {

    private final ConsultantRepository consultantRepository;


    public ConsultantsPersistenceSpi(ConsultantRepository consultantRepository) {
        this.consultantRepository = consultantRepository;
    }

    @Override
    public Long saveConsultant(CreateConsultantCommand createConsultantCommand) {
        return consultantRepository.save(ConsultantsMappers.INSTANCE.fromDomain(createConsultantCommand)).getId();
    }
}
