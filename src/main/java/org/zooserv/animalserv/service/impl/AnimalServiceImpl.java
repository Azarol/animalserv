package org.zooserv.animalserv.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.zooserv.animalserv.client.AnimalClient;
import org.zooserv.animalserv.model.Animal;
import org.zooserv.animalserv.service.AnimalBaseService;
import org.zooserv.animalserv.service.AnimalService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalClient animalClient;

    @Autowired
    private AnimalBaseService animalBaseService;

    private static final Logger LOGGER = LogManager.getLogger("org.zooserv.animalserv");

    @Override
    public List<Animal> getAnimals() {
        UUID uuid = UUID.randomUUID();

        ResponseEntity<List<Animal>> response = animalClient.getAnimals();
        Integer responseCode = response.getStatusCodeValue();
        List<Animal> listOfAnimal = response.getBody();

        String info = "UUID: " + uuid.toString() + " | Response Code: " + responseCode + " | " + listOfAnimal.stream().map(Animal::getName).collect(Collectors.joining(", "));
        LOGGER.info(info);

        animalBaseService.saveResponse(info);

        return listOfAnimal;
    }
}
