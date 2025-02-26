package com.teachmeskills.lesson_38.app;

import com.teachmeskills.lesson_38.services.MyService;
import com.teachmeskills.lesson_38.utils.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 1. Create an aspect that will measure the running time of all
 * methods and log those that run for more than 1 second.
 *
 * 2. Create an annotation, using which we will get the execution
 * time of the method it is working on.
 */

public class ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService myService = context.getBean(MyService.class);

        try {
            myService.performTask();
            myService.processData();
            myService.calculateSum(new int[]{1, 2, 3, 4, 5});
            myService.fetchData();
        } catch (InterruptedException e) {
            logger.error("An error occurred while completing the task -> ", e);
        }
    }
}