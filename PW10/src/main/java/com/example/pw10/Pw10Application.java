package com.example.pw10;


import com.example.pw10.Config.BeanConfig;
import com.example.pw10.Interfaces.Lighter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Pw10Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        ((Lighter) context.getBean("firefly")).doLight();
        ((Lighter) context.getBean("flashlight")).doLight();
        ((Lighter) context.getBean("lamp")).doLight();

    }

}
