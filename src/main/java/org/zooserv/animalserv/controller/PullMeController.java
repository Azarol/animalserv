package org.zooserv.animalserv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zooserv.animalserv.service.AnimalService;

@RestController
public class PullMeController {
    @Autowired
    private AnimalService animalService;

    @GetMapping("/pullme")
    public String pullMe() {

        animalService.getAnimals();

        return "Thanks for pulling me!";
    }
}
