package com.dassiorleando.spring_camel_integration_demo.route;

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

        rest("/file-process").description("File process REST Endpoint")
            .consumes("application/json")
            .produces("application/json")

            .get().description("File process endpoint.")
                .outType(ResponseDTO.class)
                .responseMessage().code(200).message("Return some data").endResponseMessage()
                .to("direct:file-process");
    }

}
