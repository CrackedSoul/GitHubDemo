package cn.mastercom.demo.elasticsearch;

import cn.mastercom.demo.elasticsearch.domain.Student;
import cn.mastercom.demo.elasticsearch.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class DemoElasticsearchApplication implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;
    public static void main(String[] args) {
        SpringApplication.run(DemoElasticsearchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        init();
            for (Student student:this.studentRepository.findBySex("Mail")){
                System.out.println(student);
            }
            System.out.println(this.studentRepository.findByName("Name--8"));
            destory();
    }

    private void init(){
        Random random=new Random();
        for(int i=0;;){
            Student student=new Student(20+ random.nextInt(10),"Name--"+i,random.nextInt()%2==0?"Mail":"Femail");
            student.setId(i);
            this.studentRepository.save(student);
            if (i++>100)
                break;
        }
    }
    private void destory(){
//        this.studentRepository.deleteAll();
    }
}
