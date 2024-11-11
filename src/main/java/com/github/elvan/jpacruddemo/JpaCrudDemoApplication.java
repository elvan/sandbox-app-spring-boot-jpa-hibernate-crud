package com.github.elvan.jpacruddemo;

import com.github.elvan.jpacruddemo.dao.StudentDAO;
import com.github.elvan.jpacruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaCrudDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(JpaCrudDemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
    return runner -> {
      createStudent(studentDAO);

      createMultipleStudents(studentDAO);
    };
  }

  private void createMultipleStudents(StudentDAO studentDAO) {
    // create multiple students
    System.out.println("Creating 3 student objects ...");
    Student tempStudent1 = new Student("John", "Doe", "john@example.com");
    Student tempStudent2 = new Student("Mary", "Public", "mary@example.com");
    Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@example.com");

    // save the student objects
    System.out.println("Saving the students ...");
    studentDAO.save(tempStudent1);
    studentDAO.save(tempStudent2);
    studentDAO.save(tempStudent3);
  }

  private void createStudent(StudentDAO studentDAO) {
    // create the student object
    System.out.println("Creating new student object ...");
    Student tempStudent = new Student("Paul", "Doe", "paul@example.com");

    // save the student object
    System.out.println("Saving the student ...");
    studentDAO.save(tempStudent);

    // display id of the saved student
    System.out.println("Saved student. Generated id: " + tempStudent.getId());
  }

}
