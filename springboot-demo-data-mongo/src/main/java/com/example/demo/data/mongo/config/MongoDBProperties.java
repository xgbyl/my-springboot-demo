package com.example.demo.data.mongo.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

//@Validated
//@Data
//@ConfigurationProperties(prefix = "spring.data.mongodb.custom")
public class MongoDBProperties {
    @NotBlank
    private String database;

    @NotEmpty
    private List<String> hosts;

    @NotEmpty
    private List<Integer> ports;

    private String replicaSet;
    private String username;
    private String password;
    private String authenticationDatabase;
    private Integer minConnections;
    private Integer maxConnections;
    private Integer maxQueue;
}
