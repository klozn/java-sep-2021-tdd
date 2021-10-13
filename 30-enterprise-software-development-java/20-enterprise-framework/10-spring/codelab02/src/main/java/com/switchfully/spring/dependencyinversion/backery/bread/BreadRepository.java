package com.switchfully.spring.dependencyinversion.backery.bread;

public interface BreadRepository {
    Bread getBreadByName(String name);
}
