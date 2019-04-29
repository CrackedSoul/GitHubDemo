package cn.mastercom.demo.cache.service;

import cn.mastercom.demo.cache.domain.Student;
import cn.mastercom.demo.cache.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = StudentService.cachekey)
public class StudentService {
    public  static final String cachekey="Students-Cache";
    @Autowired
    private StudentMapper studentMapper;
    @Cacheable(key = "#id")
    public Student getStudent(Integer id ){
       return studentMapper.getStudent(id);
    }
    @CachePut(keyGenerator ="keyGen" )
    public void  addStudent(Student add ) throws Exception {
           studentMapper.addStudent(add);
    }
    @CachePut(keyGenerator ="keyGen" )
    public void updateStudent(Student update ) throws Exception {
         studentMapper.updateStudent(update);
    }
    @CacheEvict(keyGenerator ="keyGen")
    public void deleteStudent(Student del ) throws Exception {
        studentMapper.deleteStudent(del);
    }
}
