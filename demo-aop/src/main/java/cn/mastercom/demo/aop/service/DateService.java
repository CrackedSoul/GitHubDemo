package cn.mastercom.demo.aop.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DateService {
    public Date getDate(){
        return new Date();
    }

    public Date newDate() throws Exception {
        throw new Exception("My Exception");
    }
}
