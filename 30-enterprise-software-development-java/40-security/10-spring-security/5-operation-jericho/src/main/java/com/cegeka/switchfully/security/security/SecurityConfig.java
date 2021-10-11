package com.cegeka.switchfully.security.security;

import com.cegeka.switchfully.security.army.InformationResource;
import com.cegeka.switchfully.security.security.authentication.ArmyAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationEntryPoint authEntryPoint;
    private final ArmyAuthenticationProvider armyAuthenticationProvider;

    @Autowired
    public SecurityConfig(AuthenticationEntryPoint authEntryPoint, ArmyAuthenticationProvider armyAuthenticationProvider) {
        this.authEntryPoint = authEntryPoint;
        this.armyAuthenticationProvider = armyAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.csrf().disable().authorizeRequests()
                .antMatchers(InformationResource.INFORMATION_RESOURCE_PATH).permitAll()
                .anyRequest().authenticated()
                .and().httpBasic()
                .authenticationEntryPoint(authEntryPoint);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(armyAuthenticationProvider);
    }

}
