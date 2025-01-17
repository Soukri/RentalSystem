package com.rental.management;

import com.rental.management.entity.Role;
import com.rental.management.entity.User;
import com.rental.management.repository.RoleRepository;
import com.rental.management.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class TestDataRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public TestDataRunner(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Δημιουργία ρόλων
        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setName("USER");
        roleRepository.save(userRole);

        // Δημιουργία χρήστη
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("password");
        admin.setEmail("admin@example.com");
        admin.setRoles(Set.of(adminRole));
        userRepository.save(admin);

        System.out.println("Δεδομένα δημιουργήθηκαν επιτυχώς!");
    }
}
