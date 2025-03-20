package com.dassiorleando.spring_camel_integration_demo.route;

import com.dassiorleando.spring_camel_integration_demo.service.SampleService;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class AlertRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:alert")
            .choice()
                .when(simple("${body.operation} == 'SLACK'"))
                    .transform(simple("${body.message}"))
                    .toD("slack:general")
                    .log(">>> The 'SLACK' alert is sent to the channel")
                    .bean(SampleService.class, "getResponse(${exchange})")
                .endChoice()
                .when(simple("${body.operation} == 'SMS'"))
                    .setProperty("from", simple("+1xxxxxxxxxx"))
                    .setProperty("to", simple("+1xxxxxxxxxx"))
                    .toD("twilio:message/create?from=${exchangeProperty.from}&to=${exchangeProperty.to}&body=${body.message}")
                    .log(">>> The 'SMS' alert is sent to the phone number")
                    .bean(SampleService.class, "getResponse(${exchange})")
                .endChoice()
                .otherwise()
                    .transform(simple("Unknown '${body.operation}' operation."))
                    .to("direct:error-400")
            .end()
            .log(">>> New alert processed.");

        from("direct:error-400")
            .log("Syntax error or invalid data.")
            .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400));
    }

}
