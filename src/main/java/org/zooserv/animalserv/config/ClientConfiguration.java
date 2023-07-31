package org.zooserv.animalserv.config;

import org.springframework.context.annotation.Bean;

import feign.codec.ErrorDecoder;

public class ClientConfiguration {
    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
}
