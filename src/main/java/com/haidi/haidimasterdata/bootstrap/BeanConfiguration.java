package com.haidi.haidimasterdata.bootstrap;

import com.haidi.haidimasterdata.domain.ports.in.ConsultantCreator;
import com.haidi.haidimasterdata.domain.ports.out.ConsultantPersistencePort;
import com.haidi.haidimasterdata.domain.services.ConsultantCreatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration  {

    /** Spring beans configuration */
    @Bean
    ConsultantCreator consultantCreator(ConsultantPersistencePort consultantPersistencePort){
        return new ConsultantCreatorService(consultantPersistencePort);
    }

}
