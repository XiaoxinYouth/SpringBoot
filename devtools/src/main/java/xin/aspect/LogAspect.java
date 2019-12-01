package xin.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author : 小新青年
 * @date : 2019-11-26  22:10
 * 描述 : 切面类
 **/
@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* xin.controller.*.hello(..))")
    public void pt1(){}

    @Before("pt1()")
    public void before() {
        System.out.println("before 方法开始执行了");
    }

    @After("pt1()")
    public void after(JoinPoint jp) {
        System.out.println(jp.getSignature().getName() + "方法执行了");
    }
}
