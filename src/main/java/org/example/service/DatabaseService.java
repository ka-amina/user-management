package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DatabaseService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

  
    public String testConnection() {
        try {
            String result = jdbcTemplate.queryForObject("SELECT version()", String.class);
            return "Database connected successfully! PostgreSQL version: " + result;
        } catch (Exception e) {
            return "Database connection failed: " + e.getMessage();
        }
    }

    public List<Map<String, Object>> executeQuery(String query) {
        return jdbcTemplate.queryForList(query);
    }

    public int getCount(String tableName) {
        String query = "SELECT COUNT(*) FROM " + tableName;
        return jdbcTemplate.queryForObject(query, Integer.class);
    }
}
