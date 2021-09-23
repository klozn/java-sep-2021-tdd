package com.switchfully.programming.advanced.integration.testing.laundry;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LaundryRepository extends JpaRepository<Laundry, Long> {

    Laundry getLaundryByOwner(String name);
}
