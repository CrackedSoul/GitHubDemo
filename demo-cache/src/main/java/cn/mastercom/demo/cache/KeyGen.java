package cn.mastercom.demo.cache;

import cn.mastercom.demo.cache.domain.Student;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
@Component
public class KeyGen implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
            return ((Student)params[0]).getId();
    }
}
