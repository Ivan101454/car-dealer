package ru.clevertec.spingbootmetricstarter.configuration;


import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@RequiredArgsConstructor
public class PerformanceMonitorAspect {

    private final PerformanceMonitorProperties performanceMonitorProperties;
    Logger logger = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("@annotation(ru.clevertec.spingbootmetricstarter.annotation.MonitorPerformance)")
    public Object methodExecuteTime(ProceedingJoinPoint joinPoint) throws Throwable {
        if(!performanceMonitorProperties.isEnabled()) {
            return joinPoint.proceed();
        }

        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        if(executionTime >= performanceMonitorProperties.getMinTimeExecute()) {
            logger.info("Method %s executed in %s ms".formatted(joinPoint.getSignature(), executionTime));
        }
        return proceed;
    }
}
