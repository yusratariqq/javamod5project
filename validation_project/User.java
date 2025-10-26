package com.example;

import jakarta.validation.constraints.*;

public class User {
    @NotBlank(message = "Username is required")
    private String username;

    @Email(message = "Invalid email")
    private String email;

    @Min(value = 18, message = "Must be at least 18")
    private int age;

    // Add this constructor
    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }

    // Add these getters
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
}