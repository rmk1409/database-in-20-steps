package com.veselov.alex.databasein20steps.data;

import com.veselov.alex.databasein20steps.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcIDao {

    @Autowired
    private JdbcTemplate template;

    public List<Person> findAll() {
        return this.template.query("select * from Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id) {
        return this.template.queryForObject(
                "select * from Person where id = ?"
                , new Object[]{id}
                , new BeanPropertyRowMapper<>(Person.class)
        );
    }

    public int deleteById(int id) {
        return this.template.update(
                "delete from Person where id = ?"
                , new Object[]{id}
        );
    }

    public int insert(Person person) {
        return this.template.update(
                "insert into person (id, name, location, birth_date) values(?, ?, ?, ?)"
                , new Object[]{person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime())}
        );
    }

    public int update(Person person) {
        return this.template.update(
                "update person set name = ?, location = ?, birth_date = ? where id = ?"
                , new Object[]{person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId()}
        );
    }

    public List<Person> findByName(String name) {
        return this.template.query(
                "select * from Person where name = ?"
                , new Object[]{name}
                , new BeanPropertyRowMapper<>(Person.class)
        );
    }

    public List<Person> findByLocation(String location) {
        return this.template.query(
                "select * from Person where location = ?"
                , new Object[]{location}
                , new BeanPropertyRowMapper<>(Person.class)
        );
    }
}
