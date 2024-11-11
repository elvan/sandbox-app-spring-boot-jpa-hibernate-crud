package com.github.elvan.jpacruddemo.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import com.github.elvan.jpacruddemo.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

  // define field for entity manager
  private EntityManager entityManager;

  // inject entity manager using constructor injection
  public StudentDAOImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  // implement save method
  @Override
  @Transactional
  public void save(Student theStudent) {
    entityManager.persist(theStudent);
  }

  @Override
  public Student findById(Integer id) {
    return entityManager.find(Student.class, id);
  }

  @Override
  public List<Student> findAll() {
    // create query
    TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

    // return query results
    return theQuery.getResultList();
  }

  @Override
  public List<Student> findByLastName(String theLastName) {
    // create query
    TypedQuery<Student> theQuery = entityManager.createQuery(
        "FROM Student WHERE lastName=:theData", Student.class);

    // set query parameters
    theQuery.setParameter("theData", theLastName);

    // return query results
    return theQuery.getResultList();
  }

}
