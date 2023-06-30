package com.feng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ChannelSdkApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChannelSdkApplication.class, args);
    }
}
