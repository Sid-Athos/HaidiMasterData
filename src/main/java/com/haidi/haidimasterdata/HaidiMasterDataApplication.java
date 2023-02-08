package com.haidi.haidimasterdata;

import com.haidi.haidimasterdata.bootstrap.BeanConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({BeanConfiguration.class})
public class HaidiMasterDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(HaidiMasterDataApplication.class, args);
    }

}
