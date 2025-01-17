package com.rental.management.repository;

import com.rental.management.entity.ViewingRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewingRequestRepository extends JpaRepository<ViewingRequest, Long> {
}
