package com.jayden.swagger.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "swagger")
public class SwaggerBean {
    private String basePackage;

    private String title;

    private String contactName;

    private String contactUrl;

    private String contactEmail;

    private String version;

    private String description;
}
