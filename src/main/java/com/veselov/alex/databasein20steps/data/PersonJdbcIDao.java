package com.veselov.alex.databasein20steps.data;

import com.veselov.alex.databasein20steps.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcIDao {

    @Autowired
    private JdbcTemplate template;

    public List<Person> findAll() {
        return this.template.query("select * from Person", new BeanPropertyRowMapper<>(Person.class));
    }
}
