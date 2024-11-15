package com.github.elvan.jpacruddemo.dao;

import java.util.List;

import com.github.elvan.jpacruddemo.entity.Student;

public interface StudentDAO {

  void save(Student theStudent);

  Student findById(Integer id);

  List<Student> findAll();

  List<Student> findByLastName(String theLastName);

  void update(Student theStudent);

  void delete(Integer id);

  int deleteAll();

}
