package com.ducvo.hl7middleman;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.hl7.HL7DataFormat;
import org.apache.camel.component.netty.NettyEndpoint;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

@Component
public class HL7Route extends RouteBuilder {

  @Override
  public void configure() throws Exception {

    for (int i  = 0; i < 5; i++){
      from("netty:tcp://0.0.0.0:"+ (5000 + i)  + "?sync=true&encoders=#hl7encoder&decoders=#hl7decoder")
          .to("log:hl7v2")
          .marshal().hl7()
          .to("rabbitmq:hl7v2?exchangePattern=InOut");
    }
  }
}
