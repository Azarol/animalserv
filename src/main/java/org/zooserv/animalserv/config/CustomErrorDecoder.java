package org.zooserv.animalserv.config;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        // в реальном приложении нужно обрабатывать ошибки, писать логи и т.д.
        switch (response.status()){
            case 400:
                return new Exception("Bad Request");
            case 404:
                return new Exception("Not found");
            default:
                return new Exception("Generic error");
        }
    }
}
