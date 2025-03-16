package com.dassiorleando.spring_camel_integration_demo.service;

import com.dassiorleando.spring_camel_integration_demo.dto.ResponseDTO;
import org.apache.camel.Exchange;

public interface SampleService {

    ResponseDTO getSampleResponse();

    void getResponse(Exchange exchange);

}
