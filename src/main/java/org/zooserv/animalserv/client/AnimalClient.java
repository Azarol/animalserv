package org.zooserv.animalserv.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.zooserv.animalserv.config.ClientConfiguration;
import org.zooserv.animalserv.model.Animal;

@FeignClient(value = "AnimalClient",
             configuration = ClientConfiguration.class,
             url = "http://localhost/")
public interface AnimalClient {

    @GetMapping(value = "/animalserv/index.json")
    ResponseEntity<List<Animal>> getAnimals();
}
