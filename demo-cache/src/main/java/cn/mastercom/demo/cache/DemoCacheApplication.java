package cn.mastercom.demo.cache;

import cn.mastercom.demo.cache.domain.Student;
import cn.mastercom.demo.cache.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemoCacheApplication implements CommandLineRunner {
    @Autowired
    private  StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(DemoCacheApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for(int i=0;i<10;i++){
            Student student=new Student(i,20+i,"Name--"+i,i%3==0?"Mail":"Famail");
            this.studentService.addStudent(student);
        }
        this.studentService.getStudent(4);
        this.studentService.getStudent(4);
        this.studentService.getStudent(4);
    }
}
