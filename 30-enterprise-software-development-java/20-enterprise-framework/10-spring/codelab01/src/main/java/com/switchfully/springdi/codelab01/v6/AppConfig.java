package com.switchfully.springdi.codelab01.v6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public PackageDealSmartPhoneWithSubscription getPackageDeal() {
        return new PackageDealSmartPhoneWithSubscription(getSmartPhone(), getPhoneSubscription());
    }

    @Bean
    public Smartphone getSmartPhone() {
        return new Smartphone();
    }

    @Bean
    public PhoneSubscription getPhoneSubscription() {
        return new PhoneSubscription();
    }
}
