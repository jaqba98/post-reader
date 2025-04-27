package com.jakubolejarczyk;

import com.jakubolejarczyk.application.Application;
import com.jakubolejarczyk.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Application application = context.getBean(Application.class);
        application.start();
        context.close();
    }
}
