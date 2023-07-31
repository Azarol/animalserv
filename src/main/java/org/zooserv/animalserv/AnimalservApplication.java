package org.zooserv.animalserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AnimalservApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimalservApplication.class, args);
    }
}
