package cn.mastercom.demo.redis;

import cn.mastercom.demo.redis.domain.Student;
import cn.mastercom.demo.redis.redis.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
public class DemoRedisApplication implements CommandLineRunner {

    private StringValue stringValue;
    private StringHash stringHash;
    private StringList stringList;
    private StringSet stringSet;
    private StringZSet stringZSet;

    @Autowired
    public void setStringHash(StringHash stringHash) {
        this.stringHash = stringHash;
    }

    @Autowired
    public void setStringList(StringList stringList) {
        this.stringList = stringList;
    }

    @Autowired
    public void setStringSet(StringSet stringSet) {
        this.stringSet = stringSet;
    }

    @Autowired
    public void setStringZSet(StringZSet stringZSet) {
        this.stringZSet = stringZSet;
    }

    @Autowired
    public void setStringValue(StringValue stringValue) {
        this.stringValue = stringValue;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoRedisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Student s = new Student();
            s.setId(i);
            s.setName("ID:Name:" + i);
            this.stringValue.set("ID:" + i, s);
            this.stringHash.put("StudentsHash", ""+i, s);
            this.stringList.push("StudentsList", s);
            this.stringSet.add("StudentSet", s);
            this.stringZSet.add("StudentZSet", s, i);
        }
        Student s=(Student) this.stringValue.get("ID:"+5);
        Map studentMap=this.stringHash.get("StudentsHash");
        List studentList=this.stringList.getList("StudentsList");
        Set studentSet=this.stringSet.get("StudentSet");
        Set studentZSet=this.stringZSet.get("StudentZSet");
    }


}
