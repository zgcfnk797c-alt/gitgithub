package com.example.gitgithub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GitgithubApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitgithubApplication.class, args);
        
        // BUG SIMULÉ
        file1 file = new file1();
        System.out.println("Message: " + file.getMessage());
        System.out.println("Author: " + file.getAuthor());
        
        User user = new User(1L, "yassine", "yassine@example.com");
        System.out.println("User créé: " + user);
        
        Product product = new Product(1L, "Laptop", 999.99, 10);
        System.out.println("Product créé: " + product);
    }
}