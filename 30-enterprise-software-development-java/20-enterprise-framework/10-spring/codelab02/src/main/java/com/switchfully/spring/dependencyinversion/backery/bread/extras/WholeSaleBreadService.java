package com.switchfully.spring.dependencyinversion.backery.bread.extras;

import com.switchfully.spring.dependencyinversion.backery.bread.Bread;
import com.switchfully.spring.dependencyinversion.backery.bread.BreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("wholesale")
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
