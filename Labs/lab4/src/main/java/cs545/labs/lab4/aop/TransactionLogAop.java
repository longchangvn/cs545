package cs545.labs.lab4.aop;

import cs545.labs.lab4.domain.ExceptionLog;
import cs545.labs.lab4.domain.TransactionLog;
import cs545.labs.lab4.repository.ExceptionLogRepo;
import cs545.labs.lab4.repository.TransactionLogRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cs545.labs.lab4.anotations.*;
import org.springframework.util.StopWatch;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class TransactionLogAop {

    @Autowired
    TransactionLogRepo repo;

    @Autowired
    ExceptionLogRepo exRepo;

    @After("execution(public * cs545.labs.lab4.*.*.*(..))")
    public void log(JoinPoint point) {
        var tran = new TransactionLog();
        tran.setDate(LocalDate.now());
        tran.setTime(LocalTime.now());
        tran.setPrinciple("system");
        tran.setOperation(point.getSignature().getName());
        repo.save(tran);
    }
    @Around("@annotation(cs545.labs.lab4.anotations.LogExecutionTime)")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        StopWatch watch = new StopWatch();
        watch.start();
        // Proceed with the actual method execution
        Object result = joinPoint.proceed();
        watch.stop();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

//        System.out.println(
//                joinPoint.getSignature() + " executed in " + executionTime + "ms");

        System.out.println(watch);
        return result;
    }

    @AfterThrowing(value = "execution(* cs545.labs.lab4.*.*.*(..))", throwing = "exception")
    public void logException(JoinPoint point,Exception exception) {

        var ex = new ExceptionLog();
        ex.setDate(LocalDate.now());
        ex.setTime(LocalTime.now());
        ex.setPrinciple("system");
        ex.setOperation(point.getSignature().getName());
        ex.setExceptionType(exception.getClass().getTypeName());

        exRepo.save(ex);
    }
}
