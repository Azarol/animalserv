package org.zooserv.animalserv.service.impl;

import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.WireMockServer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zooserv.animalserv.AnimalservApplication;
import org.zooserv.animalserv.client.AnimalClient;
import org.zooserv.animalserv.model.Animal;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AnimalservApplication.class)
class AnimalServiceImplTest {

    @Autowired
    private AnimalClient animalClient;

    private WireMockServer wireMockServer;

    @BeforeEach
    public void startWireMockServer() {
        wireMockServer = new WireMockServer(8085);
        configureFor("localhost", 8085);
        wireMockServer.start();
    }

    @AfterEach
    public void stopWireMockServer() {
        wireMockServer.stop();
    }

    @Test
    void getAnimals() {
        // увы, не получилось успеть заставить корректно работать wireMockServer, тесты не дописаны
        // java.lang.NoSuchMethodError: 'void org.eclipse.jetty.server.NetworkTrafficServerConnector.addNetworkTrafficListener(org.eclipse.jetty.io.NetworkTrafficListener)'
        String animalResponse = "{\n" +
                "    \"name\": \"Bobik\"\n" +
                "}";

        stubFor(patch(urlEqualTo("/animalserv/index.json"))
                .willReturn(aResponse().withStatus(HttpStatus.OK.value())
                .withHeader("Content-Type", "application/json")
                .withBody(animalResponse)));

        ResponseEntity<List<Animal>> listOfAnimal = animalClient.getAnimals();
    }
}