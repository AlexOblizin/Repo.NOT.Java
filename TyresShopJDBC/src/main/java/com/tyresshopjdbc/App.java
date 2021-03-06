package com.tyresshopjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        ConnectionManager connectionManager = new ConnectionManager();

        try {
            connectionManager.getConnection();

        } catch (IOException ioExc) {

            ioExc.printStackTrace();

        }
    }
}
