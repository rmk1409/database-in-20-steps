package com.veselov.alex.databasein20steps;

import com.veselov.alex.databasein20steps.data.PersonJdbcIDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseIn20StepsApplication implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseIn20StepsApplication.class);

    @Autowired
    private PersonJdbcIDao jdbc;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseIn20StepsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Show all Persons -> {}", this.jdbc.findAll());
        LOGGER.info("Find the Person (10002) -> {}", this.jdbc.findById(10002));
		LOGGER.info("Show all James -> {}", this.jdbc.findByName("James"));
		LOGGER.info("Show all New Yorks -> {}", this.jdbc.findByLocation("New York"));
	}
}
