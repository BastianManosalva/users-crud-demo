package com.example.usersdemo.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtConfig {

    private String secret;

}
