package com.example;

import jakarta.validation.*;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // Test with valid user
        User goodUser = new User("john", "john@test.com", 25);
        Set<ConstraintViolation<User>> violations = validator.validate(goodUser);
        
        System.out.println("=== GOOD USER ===");
        if (violations.isEmpty()) {
            System.out.println("✅ User is valid!");
        } else {
            for (ConstraintViolation<User> v : violations) {
                System.out.println("❌ " + v.getMessage());
            }
        }

        // Test with bad user
        User badUser = new User("", "invalid-email", 16);
        violations = validator.validate(badUser);
        
        System.out.println("\n=== BAD USER ===");
        if (violations.isEmpty()) {
            System.out.println("✅ User is valid!");
        } else {
            for (ConstraintViolation<User> v : violations) {
                System.out.println("❌ " + v.getMessage());
            }
        }
        
        factory.close();
    }
}