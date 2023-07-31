package org.zooserv.animalserv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zooserv.animalserv.model.Zoo;
import org.zooserv.animalserv.repository.ZooRepository;
import org.zooserv.animalserv.service.AnimalBaseService;

@Service
public class AnimalBaseServiceImpl implements AnimalBaseService {

    @Autowired
    private ZooRepository zooRepository;

    @Override
    @Transactional
    public Zoo saveResponse(String animalResponce) {
        return zooRepository.saveAndFlush(new Zoo(animalResponce));
    }
}
