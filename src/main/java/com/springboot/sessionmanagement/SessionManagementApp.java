package com.springboot.sessionmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SessionManagementApp {

    private static final Logger log = LoggerFactory.getLogger(SessionManagementApp.class);

    public static void main(String[] args) {
        SpringApplication.run(SessionManagementApp.class, args);
        log.info("Spring-boot-session-management application started successfully.");
    }
}
