package com.dassiorleando.spring_camel_integration_demo.service;

import com.dassiorleando.spring_camel_integration_demo.dto.ResponseDTO;
import org.apache.camel.Exchange;
import org.apache.camel.util.json.JsonObject;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {

    @Override
    public ResponseDTO getSampleResponse() {
        return new ResponseDTO(true, "Test message", Map.of("key1", "value1", "key2", "value2"));
    }

    @Override
    public void getResponse(Exchange exchange) {
        Map<String, Object> body = exchange.getIn().getBody(Map.class);
        JsonObject jo = new JsonObject();
        jo.put("success", true);
        jo.put("message", "Action processed successfully.");
//        jo.put("data", body);
        exchange.getIn().setBody(jo);
    }

}
