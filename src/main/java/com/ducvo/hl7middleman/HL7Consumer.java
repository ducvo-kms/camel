package com.ducvo.hl7middleman;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class HL7Consumer extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("rabbitmq:hl7v2?exchangePattern=InOut")
        .unmarshal().hl7()
        .to("log:hl7v2-listen");
  }
}
