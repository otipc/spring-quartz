package com.otipc.monitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sun.rmi.runtime.Log;

@SpringBootApplication
public class BdhMonitorApplication {

    private final static Logger log = LoggerFactory.getLogger(BdhMonitorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BdhMonitorApplication.class, args);
        log.info("started ....");
    }
}
