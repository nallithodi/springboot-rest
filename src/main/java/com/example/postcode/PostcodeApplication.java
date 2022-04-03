package com.example.postcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;

@SpringBootApplication(scanBasePackages = {"com.example"})
@Import(SpringDataRestConfiguration.class)
public class PostcodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostcodeApplication.class, args);
    }

}
