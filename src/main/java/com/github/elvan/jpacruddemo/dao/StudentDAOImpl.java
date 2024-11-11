package com.github.elvan.jpacruddemo.dao;

import jakarta.persistence.EntityManager;

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

}
