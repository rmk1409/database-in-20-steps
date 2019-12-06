package com.veselov.alex.databasein20steps.data;

import com.veselov.alex.databasein20steps.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDataRepository extends JpaRepository<Person, Integer> {
}
