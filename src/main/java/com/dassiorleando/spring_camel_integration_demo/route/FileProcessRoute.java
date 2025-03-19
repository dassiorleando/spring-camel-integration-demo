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
            .log(">>> read file from the file system")

            .setHeader("CamelAwsS3Key", simple("${date:now:yyyy-MM-dd}-${file:name}"))
            .to("aws2-s3://demo-camel-bucket")
            .log(">>> file pushed to S3")

            .setProperty("from", simple("+1xxxxxxxxxx"))
            .setProperty("to", simple("+1xxxxxxxxxx"))
            .setProperty("message", simple("Fake message for Camel demo."))
            .toD("twilio:message/create?from=${exchangeProperty.from}&to=${exchangeProperty.to}&body=${exchangeProperty.message}")
            .log(">>> The SMS is sent to phone number")

            .transform(simple("File processed successfully!"))
            .toD("slack:general")
            .log(">>> Slack channel notified")

            .bean(SampleService.class, "getResponse(${exchange})")
            .log("New file processed: ${file:name}");
    }

}
