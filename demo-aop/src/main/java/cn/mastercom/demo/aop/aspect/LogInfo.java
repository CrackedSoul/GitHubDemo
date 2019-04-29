package cn.mastercom.demo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogInfo {
    @Pointcut("execution(* cn.mastercom.demo.aop.service.*Service.*(..))")
    public void log(){}

    @Before("log()")
    public void before(JoinPoint joinPoint){
        System.out.println("LogINFO-------方法执行之前------");
    }
    @After("log()")
    public void after(JoinPoint joinPoint){
        System.out.println("LogINFO-------方法执行之后------");
    }
    @AfterReturning(pointcut="log()",returning = "result")
    public void afterReturn(JoinPoint joinPoint,Object result){
        System.out.println("LogINFO-------方法正常返回之后------");
        System.out.println(result.toString());
    }
    @AfterThrowing(pointcut="log()",throwing="exception")
    public void afterThrow(JoinPoint joinPoint,Throwable  exception){
        System.out.println("LogINFO-------方法抛出异常之后-----");
        System.out.println(exception.toString());
    }
    @Around("log()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("LogINFO-------方法环绕通知开始-----");
        Object obj= (Object) pjp.proceed();
        System.out.println("LogINFO-------方法环绕通知结束-----");
        return obj;
    }
}
