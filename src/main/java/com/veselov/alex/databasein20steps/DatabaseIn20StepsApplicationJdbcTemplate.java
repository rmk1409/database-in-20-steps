package com.veselov.alex.databasein20steps;

import com.veselov.alex.databasein20steps.bean.Person;
import com.veselov.alex.databasein20steps.data.PersonJdbcIDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.Date;

//@SpringBootApplication
public class DatabaseIn20StepsApplicationJdbcTemplate implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseIn20StepsApplicationJdbcTemplate.class);

    @Autowired
    private PersonJdbcIDao jdbc;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseIn20StepsApplicationJdbcTemplate.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Show all Persons -> {}", this.jdbc.findAll());
        LOGGER.info("Find the Person (10002) -> {}", this.jdbc.findById(10002));
        LOGGER.info("Show all James -> {}", this.jdbc.findByName("James"));
        LOGGER.info("Show all New Yorks -> {}", this.jdbc.findByLocation("New York"));
        LOGGER.info("Delete the Person (10002) Numbers of rows deleted -> {}", this.jdbc.deleteById(10002));
        LOGGER.info("Show all Persons -> {}", this.jdbc.findAll());
        Person ivan = new Person(1, "Ivan", "Spb", new Date());
        LOGGER.info("Insert {}", ivan);
        this.jdbc.insert(ivan);
        LOGGER.info("Show all Persons -> {}", this.jdbc.findAll());
        LOGGER.info("Update location of {}", ivan);
        ivan.setLocation("Msc");
        this.jdbc.update(ivan);
        LOGGER.info("Show all Persons -> {}", this.jdbc.findAll());
    }
}
