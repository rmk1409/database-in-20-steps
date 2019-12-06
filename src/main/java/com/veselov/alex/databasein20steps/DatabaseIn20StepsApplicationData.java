package com.veselov.alex.databasein20steps;

import com.veselov.alex.databasein20steps.bean.Person;
import com.veselov.alex.databasein20steps.data.PersonDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DatabaseIn20StepsApplicationData implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseIn20StepsApplicationData.class);

    @Autowired
    private PersonDataRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseIn20StepsApplicationData.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Person ranga = this.repository.findById(10001).get();
        LOGGER.info("Data finds with id(10001) -> {}", ranga);
        LOGGER.info("Data update 'Ranga'");
        ranga.setLocation("Msc");
        this.repository.save(ranga);
        LOGGER.info("Data finds with id(10001) -> {}", ranga);
        LOGGER.info("Data creates new Person");
        Person ivan = new Person("Ivan", "Spb", new Date());
        this.repository.save(ivan);
        LOGGER.info("Data finds all-> {}", this.repository.findAll());
        LOGGER.info("Data removing (Ranga)");
        this.repository.deleteById(10001);
        LOGGER.info("Data finds all-> {}", this.repository.findAll());
    }
}
