package com.switchfully.spring.dependencyinversion.backery;

import com.switchfully.spring.dependencyinversion.backery.bread.Bread;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@ComponentScan
@Profile(value = "normal | fancy | wholesale")
public class BakeryMain {

    public static void main(String... args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BakeryMain.class);
        for (String arg : args) {
            System.out.println(arg);
        }
        if (args.length == 1) {
            System.setProperty("spring.profiles.active", args[0]);
        }

        BakeryResource bakeryResource = ctx.getBean(BakeryResource.class);
        Bread bread = bakeryResource.getBreadByName("witbrood");

        System.out.println(bread);
    }
}
