package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer> {
//    @Query(value =  "select * from students " +
//            "inner join group on students.group_id = `group`.group_id " +
//            "inner join tutor on students.tutor_id = tutor.tutor " +
//            "where concat(`code`, email, `name`, phone, `nameProject`, group_name, tutor_name) like ?1",
//            nativeQuery = true)
    List<Student> findAll(String name);
}
