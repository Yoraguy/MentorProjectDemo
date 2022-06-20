package com.mentorproject.Dao;

import com.mentorproject.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRep extends JpaRepository<Student,String> {

    @Query(value = "select" +
            "           student_id, student_name, gender, gpa, password" +
            "       from " +
            "           mentor.student " +
            "       where student_id=?1 and password=?2",
            nativeQuery = true)
    List<Student> logCheck(String student_id, String password);

    @Transactional
    @Modifying
    @Query(value = "insert into application" +
            "       (student_id, first_app, second_app, third_app, is_selected) VALUES (?1,?2,?3,?4,?5)",
            nativeQuery = true)
    int fillApplication(String student_id, Integer FirstApp, Integer SecondApp, Integer ThirdApp, Integer IsSelected);


}
