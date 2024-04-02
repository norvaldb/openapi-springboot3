package com.demo.employees;

import com.fasterxml.jackson.databind.Module;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

@SpringBootApplication(
    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@ComponentScan(
    basePackages = {"com.demo.employees",
            "com.demo.employees.api",
            "com.demo.employees.config",
            "com.demo.employees.facade",
            "com.demo.employees.repository",
            "com.demo.employees.domain"},
    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
public class OpenApiGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenApiGeneratorApplication.class, args);
    }

    @Bean(name = "com.demo.employees.OpenApiGeneratorApplication.jsonNullableModule")
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}