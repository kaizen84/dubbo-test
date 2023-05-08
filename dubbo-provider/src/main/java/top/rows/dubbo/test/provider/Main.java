package top.rows.dubbo.test.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class Main {


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}