package cn.mastercom.demo.dubbo.service;

import cn.mastercom.demo.dubbo.domain.Student;

import java.util.List;

public interface StudentService {
     Student getStudent(Integer id);
     List<Student> getStudents();
     void addStudent(Student student) throws Exception;
     void updateStudent(Student student) throws Exception;
     void deleteStudent(Student student) throws Exception;
}
