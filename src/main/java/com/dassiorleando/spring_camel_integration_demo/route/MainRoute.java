package com.dassiorleando.spring_camel_integration_demo.route;

import com.dassiorleando.spring_camel_integration_demo.dto.AlertDTO;
import com.dassiorleando.spring_camel_integration_demo.dto.ResponseDTO;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MainRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        rest("/ping").description("Ping REST Endpoint")
            .consumes("application/json")
            .produces("application/json")

            .get().description("Test endpoint.")
                .outType(ResponseDTO.class)
                .responseMessage().code(200).message("Return the sample data").endResponseMessage()
                .to("bean:sampleService?method=getSampleResponse()");

        rest("/alert").description("Alert REST Endpoint")
            .consumes("application/json")
            .produces("application/json")

            .post().description("Send a notification to the team.")
                .type(AlertDTO.class)
                .outType(ResponseDTO.class)
//                .param().name("id").type(path).description("The ID of the entity").dataType("string").endParam()
                .responseMessage().code(200).message("Alert sent.").endResponseMessage()
                .to("direct:alert");
    }

}
