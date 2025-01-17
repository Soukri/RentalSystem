package com.rental.management.repository;

import com.rental.management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Μπορείς να προσθέσεις custom queries εδώ αν χρειαστεί
}
