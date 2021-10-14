package com.switchfully.spring.dependencyinversion.backery.bread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("wholesale")
public class WholeSaleBreadService implements BreadService {
    private final NetworkConnectionToWholeSale connection;

    @Autowired
    public WholeSaleBreadService(NetworkConnectionToWholeSale connection) {
        this.connection = connection;
    }

    @Override
    public Bread getBreadByName(String name) {
        return new NetworkConnectionToWholeSale().getBreadByName(name);
    }
}
