package com.switchfully.programming.advanced.integration.testing.time;

import java.time.LocalDateTime;

public interface TimeProvider {

    LocalDateTime getNow();
}
