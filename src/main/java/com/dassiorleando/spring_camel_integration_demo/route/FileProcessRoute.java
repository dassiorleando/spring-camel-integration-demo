package com.dassiorleando.spring_camel_integration_demo.route;

import com.dassiorleando.spring_camel_integration_demo.service.SampleService;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileProcessRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:file-process")
            .bean(SampleService.class, "getResponse(${exchange})")
            .log("New file processed: ${file:name}");

        from("file://files/?preMove=processing&move=processed/${date:now:yyyy-MM-dd}-${file:name}")
            .bean(SampleService.class, "getResponse(${exchange})")
            .log("New file processed: ${file:name}");
    }

}
