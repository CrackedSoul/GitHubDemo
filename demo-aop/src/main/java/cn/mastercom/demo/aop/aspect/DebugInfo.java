package cn.mastercom.demo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DebugInfo {
    @Before("execution(* cn.mastercom.demo.aop.service.*Service.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("-------方法执行之前------");
    }
    @After("execution(* cn.mastercom.demo.aop.service.*Service.*(..))")
    public void after(JoinPoint joinPoint){
        System.out.println("-------方法执行之后------");
    }
    @AfterReturning(pointcut="execution(* cn.mastercom.demo.aop.service.*Service.*(..))",returning = "result")
    public void afterReturn(JoinPoint joinPoint,Object result){
        System.out.println("-------方法正常返回之后------");
        System.out.println(result.toString());
    }
    @AfterThrowing(pointcut="execution(* cn.mastercom.demo.aop.service.*Service.*(..))",throwing="exception")
    public void afterThrow(JoinPoint joinPoint,Throwable  exception){
        System.out.println("-------方法抛出异常之后-----");
        System.out.println(exception.toString());
    }
    @Around("execution(* cn.mastercom.demo.aop.service.*Service.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("-------方法环绕通知开始-----");
        Object obj= (Object) pjp.proceed();
        System.out.println("-------方法环绕通知结束-----");
        return obj;
    }
}
