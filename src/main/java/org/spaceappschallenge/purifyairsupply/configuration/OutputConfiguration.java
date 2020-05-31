package org.spaceappschallenge.purifyairsupply.configuration;

import org.spaceappschallenge.purifyairsupply.core.Controller;
import org.spaceappschallenge.purifyairsupply.core.Output;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OutputConfiguration {

    private final int ledPin;
    private final int fanPin;
    private final Controller controller;

    public OutputConfiguration(@Value("${output.led.pin}") int ledPin,
                               @Value("${output.fan.pin}") int fanPin, Controller controller) {
        this.ledPin = ledPin;
        this.fanPin = fanPin;
        this.controller = controller;
    }

    @Bean
    public Output ledOutput() {
        return controller.initOutput(ledPin);
    }

    @Bean
    public Output fanOutput() {
        return controller.initOutput(fanPin);
    }
}
