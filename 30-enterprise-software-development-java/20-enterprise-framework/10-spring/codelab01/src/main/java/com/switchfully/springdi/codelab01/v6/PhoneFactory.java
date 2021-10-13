package com.switchfully.springdi.codelab01.v6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PhoneFactory {
    public static void main(String... args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        PackageDealSmartPhoneWithSubscription funkyPhoneWithSubscription
                = ctx.getBean(PackageDealSmartPhoneWithSubscription.class);

        System.out.println("You have bought the following package: \n" +
                funkyPhoneWithSubscription.getDealInfo());
    }
}
