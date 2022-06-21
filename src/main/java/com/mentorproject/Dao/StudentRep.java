package com.mentorproject.Dao;

import com.mentorproject.Entity.Message;
import com.mentorproject.Entity.Result;
import com.mentorproject.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRep extends JpaRepository<Student,String> {

    @Query(value = "select" +
            "           student_id, student_name, gender, gpa, password" +
            "       from " +
            "           mentor.student " +
            "       where " +
            "           student_id=?1 and password=?2",
            nativeQuery = true)
    List<Student> logCheck(String student_id, String password);

    /**查看学生个人信息
     *
     * @param student_id
     * @return
     */
    @Query(value = "select " +
            "           student_id, student_name, gender, gpa, password" +
            "       from" +
            "           mentor.student" +
            "       where " +
            "           student_id = ?1",
            nativeQuery = true)
    List<Student> getInfo(String student_id);

    /**修改学生密码
     *
     * @param password
     * @param student_id
     * @return
     */
    @Transactional
    @Modifying
    @Query(value = "update " +
            "           mentor.student" +
            "       set" +
            "           (password)" +
            "       value" +
            "           (?1)" +
            "       where " +
            "           student_id = ?2",
            nativeQuery = true)
    Integer updatePassword(String password,String student_id);

    /**查看私信
     *
     * @param receiver
     * @return
     */
    @Query(value = "select " +
            "           message,is_read" +
            "       from" +
            "           mentor.message" +
            "       where " +
            "           receiver = ?1" ,
            nativeQuery = true)
    List<Message> checkMessage(String receiver);

    /**发送私信
     *
     * @param sender
     * @param receiver
     * @param message
     * @return
     */
    @Transactional
    @Modifying
    @Query(value = "insert into" +
            "           mentor.message" +
            "       values" +
            "           (?1,?2,?3)",
            nativeQuery = true)
    Integer sendmessage(String sender,String receiver,String message);

    @Query(value = "select " +
            "           student_name,teacher_name" +
            "       from" +
            "           mentormatch" +
            "       join " +
            "           student" +
            "       on" +
            "           mentormatch.student_id = student.student_id" +
            "       join" +
            "           teacher" +
            "       on" +
            "           mentormatch.teacher_id = student.teacher_id" +
            "       where " +
            "           mentor.student_id = ?1",
            nativeQuery = true)
    List<Result> checkResult(String student_id);
}
