package com.switchfully.springdi.codelab01.v4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfiguration {
    @Bean("NewLine")
    public String getString1() {
        return "\n";
    }

    @Bean("WhoAmITalkingTo")
    public String getSubject() {
        return "Lord";
    }

    @Bean("WhoAbout")
    public String abc() {
        return "friends";
    }

    @Bean("WhoAboutWhat")
    public String more() {
        return "Porsches";
    }

    @Bean("AboutWhat")
    public String theFinalString() {
        return "Mercedes Benz";
    }
}