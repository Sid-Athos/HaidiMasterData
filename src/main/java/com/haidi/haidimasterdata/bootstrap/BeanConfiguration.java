package com.haidi.haidimasterdata.bootstrap;

import com.haidi.haidimasterdata.domain.ports.in.*;
import com.haidi.haidimasterdata.domain.ports.out.*;
import com.haidi.haidimasterdata.domain.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class BeanConfiguration extends WebSecurityConfigurerAdapter {

    /** Spring beans configuration */

    @Bean
    ProductServicePort productServicePort(ProductPersistencePort productPersistencePort){
        return new ProductsOperationService(productPersistencePort);
    }

    @Bean
    ProductLocationServicePort productLocationServicePort(ProductLocationPersistencePort productLocationPersistencePort){
        return new ProductLocationOperationService(productLocationPersistencePort);
    }

    @Bean
    FamilyServicePort familyServicePort(FamilyPersistencePort familyPersistencePort){
        return new FamiliesOperationService(familyPersistencePort);
    }

    @Bean
    LocationServicePort locationServicePort(LocationPersistencePort locationPersistencePort){
        return new LocationsOperationService(locationPersistencePort);
    }

    @Bean
    LocationTypeServicePort locationTypeServicePort(LocationTypePersistencePort locationTypePersistencePort){
        return new LocationTypesOperationService(locationTypePersistencePort);
    }

    @Override
    //we have stopped the csrf to make post method work
    protected void configure(HttpSecurity http) throws Exception{
        http.cors().and().csrf().disable();
    }
}
