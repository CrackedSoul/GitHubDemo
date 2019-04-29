package cn.mastercom.demo.elasticsearch.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "student", type = "student", shards = 1, replicas = 0,
        refreshInterval = "-1")
public class Student {
    @Id
    private int id;
    private int age;
    private String name;
    private String sex;

    public Student() {
    }

    public Student(int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    @Override
    public String toString(){
        return String.format("Student[id=%s, age='%s', name='%s',sex='%s']",this.id,this.age,this.name,this.sex);
    }
}
