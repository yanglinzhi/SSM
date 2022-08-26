package com.ylz.spring.aopAnnotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 1.在切面中需要通过指定的注解将方法表示为通知方法
 *      @Before:前置通知，在目标对象方法执行之前执行
 *      @After:后置通知，在目标对象中的finally字句中执行
 *      @AfterReturning:返回通知，在目标对象方法成功执行之后执行，出现异常之后则不会执行
 *      @AfterThrowing:异常通知，在异常方法中的catch中执行，与@AfterReturning相反，有异常才会执行
 *
 *
 *
 * 2.切入点表达式设置在表示通知的注解的Value属性中
 *      execution(public int com.ylz.spring.aopAnnotation.CalculatorImpl.add(int,int))
 *      execution(* com.ylz.spring.aopAnnotation.CalculatorImpl.*(..) )
 *          第一个*表示任意的访问修饰符和返回值类型
 *          第二个*表示类中的任意方法
 *          ..表示任意参数列表
 *          类的地方也可以使用*表示包下所有类
 * 3.重用切入点表达式
 *      //@Pointcut声明一个重用的切入点表达式
 *          @Pointcut("execution(* com.ylz.spring.aopAnnotation.CalculatorImpl.*(..))")
 *          public void pointcut(){}
 *      //使用方式
 *          @Before("pointcut()")
 * 4.获取连接点信息
 *      在通知方法参数位置,设置JoinPoint类型的参数,就可以获取连接点对应的方法的信息
 *          //获取连接点对应的方法的签名信息
 *         Signature signature = joinPoint.getSignature();
 *         //获取连接点对应方法的参数
 *         Object[] args = joinPoint.getArgs();
 * 5.切面优先级
 *      可以通过@Order注解的value属性设置优先级，默认值Integer的最大值
 *      @Order的value值越小优先级越高
 *
 *
 *
 */
@Component
@Aspect
public class LoggerAspect {
    @Pointcut("execution(* com.ylz.spring.aopAnnotation.CalculatorImpl.*(..))")
    public void pointcut(){}
    //@Before("execution(public int com.ylz.spring.aopAnnotation.CalculatorImpl.add(int,int))")
    //切入点表达式的重用
    @Before("pointcut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点对应的方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,前置通知,方法"+signature.getName());
        System.out.println("LoggerAspect,前置通知,参数"+ Arrays.toString(args));
    }
    @After("pointcut()")
    public void afterAdviceMethod(){
        System.out.println("这是一个后置通知");

    }
    //returning属性用于获取返回值
    @AfterReturning(value = "pointcut()",returning = "result")
    public void afterReturningAdviceMethod(Object result){
        System.out.println("返回通知,结果" + result);
    }
    //throwing属性用于获取异常信息
    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Exception ex){
        //获取连接点对应的方法的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("方法"+signature.getName()+"出现异常,异常：" + ex);
    }
    @Around("pointcut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){

        Object result =null;
        try {
            System.out.println("环绕通知->前置通知");
            //表示目标对象方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知->返回通知");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知->异常通知");
        }finally {
            System.out.println("环绕通知->后置通知");
        }
        return result;

    }
}
