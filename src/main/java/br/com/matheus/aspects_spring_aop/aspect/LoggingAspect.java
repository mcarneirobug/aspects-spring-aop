package br.com.matheus.aspects_spring_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  /**
   * Basically we need to define the PointCut in our advice,
   * and we'll execute for all methods inside of package been any
   * method, class with whatever set of arguments.
   *
   * @param joinPoint - object intercepted
   */
  @Before("execution(* br.com.matheus.aspects_spring_aop.dummy.*.*(..))")
  public void logBefore(JoinPoint joinPoint) {
    System.out.println("Before: " + joinPoint.getSignature());
  }

  @Around("execution(* br.com.matheus.aspects_spring_aop.dummy.*.*(..))")
  public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("Around Before: " + joinPoint.getSignature());

    Object proceed = joinPoint.proceed(); // if we are not called, the method doesn't execute at all.

    System.out.println("Around After: " + joinPoint.getSignature());

    return proceed;
  }

}
