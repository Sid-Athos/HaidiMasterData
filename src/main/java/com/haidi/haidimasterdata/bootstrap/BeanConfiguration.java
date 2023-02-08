package com.haidi.haidimasterdata.bootstrap;

import com.haidi.haidimasterdata.domain.ports.in.*;
import com.haidi.haidimasterdata.domain.ports.out.*;
import com.haidi.haidimasterdata.domain.services.*;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

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

    /** Swagger conf */

    private static final String SCHEME_NAME = "basicAuth";
    private static final String SCHEME = "basic";

    @Bean
    public OpenAPI customOpenAPI( ) {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes(SCHEME_NAME, createSecurityScheme()))
                .addSecurityItem(new SecurityRequirement().addList(SCHEME_NAME));
    }
    private SecurityScheme createSecurityScheme() {
        return new SecurityScheme()
                .name(SCHEME_NAME)
                .type(SecurityScheme.Type.HTTP)
                .scheme(SCHEME);
    }
}
