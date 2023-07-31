package org.zooserv.animalserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zooserv.animalserv.model.Zoo;

public interface ZooRepository extends JpaRepository<Zoo, Integer> {
}
