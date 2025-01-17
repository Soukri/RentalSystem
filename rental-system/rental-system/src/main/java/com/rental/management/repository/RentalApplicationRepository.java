package com.rental.management.repository;

import com.rental.management.entity.RentalApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalApplicationRepository extends JpaRepository<RentalApplication, Long> {
}
