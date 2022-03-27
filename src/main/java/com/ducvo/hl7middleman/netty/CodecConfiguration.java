package com.ducvo.hl7middleman.netty;

import org.apache.camel.component.hl7.HL7MLLPNettyDecoderFactory;
import org.apache.camel.component.hl7.HL7MLLPNettyEncoderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class CodecConfiguration {
  @Bean(name = "hl7decoder")
  public HL7MLLPNettyDecoderFactory hl7Decoder() {
    return new HL7MLLPNettyDecoderFactory();
  }

  @Bean(name = "hl7encoder")
  public HL7MLLPNettyEncoderFactory hl7Encoder() {
    return new HL7MLLPNettyEncoderFactory();
  }
}
