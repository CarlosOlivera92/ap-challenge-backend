package com.portfolio.backend.controllers;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://bqkib7hnrvu7ir8slrbc-mysql.services.clever-cloud.com:3306/bqkib7hnrvu7ir8slrbc")
                .username("zMfVsiomvCyu959V0f0W")
                .password("ud15hwwwyxcqgjzm")
                .build();
    }
}