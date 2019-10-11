package com.yuphanie.ipanena.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.yuphanie.ipanena.*" })
@Import({ SecurityConfig.class })
public class DataSourceConfig {

    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/ipanena");
        dataSourceBuilder.username("ipanena");
        dataSourceBuilder.password("postgres");
        return dataSourceBuilder.build();
    }
}