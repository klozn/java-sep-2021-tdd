package com.switchfully.spring.dependencyinversion.backery;

import com.switchfully.spring.dependencyinversion.backery.bread.Bread;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class BakeryMain {

    public static void main(String args[]) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BakeryMain.class);
        BakeryResource bakeryResource = ctx.getBean(BakeryResource.class);
        Bread bread = bakeryResource.getBreadByName("witbrood");

        System.out.println(bread);
    }
}
