package com.switchfully.programming.advanced.integration.testing.time;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Profile("test")
public class TimeProviderStub implements TimeProvider {

    private LocalDateTime setTime;

    @Override
    public LocalDateTime getNow() {
        if(setTime != null) {
            return setTime;
        }
        return LocalDateTime.now();
    }

    public void freeze() {
        setTime = LocalDateTime.now();
    }

    public void reset(){
        setTime = null;
    }

    public void freezeAt(LocalDateTime localDateTime) {
        setTime = localDateTime;
    }
}
