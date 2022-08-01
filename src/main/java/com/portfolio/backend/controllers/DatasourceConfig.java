package com.portfolio.backend.controllers;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class DatasourceConfig {
    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://usxis2nbhfhgjsnq:pXU2lmkCp5IlMmNpclf@b70mlod8sf0wwuzkocfg-mysql.services.clever-cloud.com:20352/b70mlod8sf0wwuzkocfg")
                .username("usxis2nbhfhgjsnq")
                .password("pXU2lmkCp5IlMmNpclf")
                .build();
    }
}