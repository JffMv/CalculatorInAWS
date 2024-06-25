package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for serving web content using Spring Boot.
 */
@SpringBootApplication
public class ServingWebContentApplication {

    /**
     * Main method to run the Spring Boot application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ServingWebContentApplication.class, args);
    }

}
