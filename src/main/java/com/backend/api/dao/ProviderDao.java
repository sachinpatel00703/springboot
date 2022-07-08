package com.backend.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProviderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void CreateTable(){
        var query = "CREATE TABLE provider(id SERIAL PRIMARY KEY, providerName VARCHAR(255) NOT NULL, flowName VARCHAR(255) NOT NULL, downFrom DATE NOT NULL, downTo DATE NOT NULL)";
        int update = jdbcTemplate.update(query);
        System.out.println(update);
    }
}
