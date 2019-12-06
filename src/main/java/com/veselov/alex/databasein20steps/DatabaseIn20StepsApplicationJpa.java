package com.veselov.alex.databasein20steps;

import com.veselov.alex.databasein20steps.bean.Person;
import com.veselov.alex.databasein20steps.data.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DatabaseIn20StepsApplicationJpa implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseIn20StepsApplicationJpa.class);

    @Autowired
    private PersonJpaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseIn20StepsApplicationJpa.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Person ranga = this.repository.findById(10001);
        LOGGER.info("Jpa finds with id(10001) -> {}", ranga);
        LOGGER.info("Jpa update 'Ranga'");
        ranga.setLocation("Msc");
        this.repository.update(ranga);
        LOGGER.info("Jpa finds with id(10001) -> {}", ranga);
        LOGGER.info("Jpa creates new Person");
        Person ivan = new Person("Ivan", "Spb", new Date());
        this.repository.insert(ivan);
        LOGGER.info("Jpa finds all-> {}", this.repository.findAll());
        LOGGER.info("Jpa removing (Ranga)");
        this.repository.deleteById(10001);
        LOGGER.info("Jpa finds all-> {}", this.repository.findAll());
        LOGGER.info("Jpa finds all with named query-> {}", this.repository.findAllWithNamedQuery());
    }
}
