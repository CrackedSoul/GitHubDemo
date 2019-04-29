package cn.mastercom.demo.elasticsearch.repository;

import cn.mastercom.demo.elasticsearch.domain.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface StudentRepository extends ElasticsearchRepository<Student, Integer> {
    List<Student> findBySex(String sex);
    Student findByName(String name);
}
