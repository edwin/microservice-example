package com.redhat.edw.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * <pre>
 *     com.redhat.edw.ecommerce.Main
 * </pre>
 *
 * @author Muhammad Edwin < emuhamma at redhat dot com >
 * 19 Okt 2019 19:42
 */
@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
