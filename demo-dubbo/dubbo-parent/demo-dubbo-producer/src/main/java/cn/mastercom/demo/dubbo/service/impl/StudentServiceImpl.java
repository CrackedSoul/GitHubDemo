package cn.mastercom.demo.dubbo.service.impl;

import cn.mastercom.demo.dubbo.domain.Student;
import cn.mastercom.demo.dubbo.service.StudentService;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class StudentServiceImpl implements StudentService {
    private static ConcurrentHashMap<Integer, Student> students;
    static {
        students=new ConcurrentHashMap<>();
    }
    @Override
    public void addStudent(Student add) throws Exception {
        System.out.println("------------Start Add Student----------");
        if(!students.containsKey(add.getId()))
            students.put(add.getId(),add);
        else
            throw new Exception("已经存在该学生");
        System.out.println("------------End Add Student----------");
    }
    @Override
    public void updateStudent(Student update)throws Exception{
        System.out.println("------------Start Update Student----------");
        if(students.containsKey(update.getId()))
            students.put(update.getId(),update);
        else
            throw new Exception("不存在该学生");
        System.out.println("------------End Update Student----------");
    }
    @Override
    public Student getStudent(Integer id ){
        System.out.println("------------Start Get Student----------");
        Student student=students.get(id);
        System.out.println("------------End Get Student----------");
        return student;
    }

    @Override
    public List<Student> getStudents() {
        return new LinkedList<>( students.values());
    }
    @Override
    public void deleteStudent(Student delete ) throws Exception {
        System.out.println("------------Start Delete Student----------");
        if(students.containsKey(delete.getId()))
            students.remove(delete.getId());
        else
            throw new Exception("不存在该学生");
        System.out.println("------------End Delete Student----------");
    }
}
