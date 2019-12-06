package com.veselov.alex.databasein20steps.data;

import com.veselov.alex.databasein20steps.bean.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    private EntityManager manager;

    public List<Person> findAll() {
        return manager.createQuery("from Person").getResultList();
    }

    public List<Person> findAllWithNamedQuery() {
        TypedQuery<Person> query = manager.createNamedQuery("find_all_persons", Person.class);
        return query.getResultList();
    }

    public Person findById(int id) {
        return manager.find(Person.class, id);
    }

    public Person insert(Person person) {
        return manager.merge(person);
    }

    public Person update(Person person) {
        return manager.merge(person);
    }

    public void deleteById(int id) {
        manager.remove(this.findById(id));
    }
}
