package org.spaceappschallenge.purifyairsupply;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class PurifyAirSupplyApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(PurifyAirSupplyApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		log.info("Starting the app...");
	}
}
