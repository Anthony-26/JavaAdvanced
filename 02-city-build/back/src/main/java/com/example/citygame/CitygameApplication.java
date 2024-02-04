package com.example.citygame;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CitygameApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CitygameApplication.class, args);

	}

	/* Implementing CommandLineRunner and testing the */
	/* behavior of this application with code below */

	@Override
	public void run(String... args) throws Exception {
		// startGameSimulation();
	}

	// private void startGameSimulation() {

	// }

}
