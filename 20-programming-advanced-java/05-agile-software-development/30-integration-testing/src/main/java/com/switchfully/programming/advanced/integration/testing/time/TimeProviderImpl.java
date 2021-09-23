package com.switchfully.programming.advanced.integration.testing.time;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Profile("!test")
public class TimeProviderImpl implements TimeProvider {
    @Override
    public LocalDateTime getNow() {
        return LocalDateTime.now();
    }
}
