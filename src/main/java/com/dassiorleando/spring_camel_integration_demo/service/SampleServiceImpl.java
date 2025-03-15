package com.dassiorleando.spring_camel_integration_demo.service;

import com.dassiorleando.spring_camel_integration_demo.dto.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {

    @Override
    public ResponseDTO getSampleResponse() {
        return new ResponseDTO(true, "Test message", Map.of("key1", "value1", "key2", "value2"));
    }

}
