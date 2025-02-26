package com.teachmeskills.lesson_38.aspects;

import com.teachmeskills.lesson_38.annotations.LeadTimed;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Aspect
public class TimingAspect {

    private static final Logger logger = LoggerFactory.getLogger(TimingAspect.class);

    @Around("@annotation(leadTimed)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, LeadTimed leadTimed) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        if (executionTime > 1000) {
            logger.warn("The {} method was completed in {} ms. Additional info: {}",
                    joinPoint.getSignature(), executionTime, leadTimed.value());
        }
        return proceed;
    }
}