package com.spring.project1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class DbTest implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public DbTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Purely for test
    @Override
    public void run(String... args) throws Exception {
        System.out.println("✅ Connected to database!");

        String customers = "SELECT * FROM Customers";
        List<Map<String, Object>> rows_customers = jdbcTemplate.queryForList(customers);

        for(Map<String, Object> row:rows_customers){
            System.out.println("Customer ID: " + row.get("customer_id"));
            System.out.println("Customer Name: " + row.get("customer_name"));
        }
    }
}
