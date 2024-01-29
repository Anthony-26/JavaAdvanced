package com.example.citygame;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.citygame.model.houses.FarmerHouse;
import com.example.citygame.model.resources.Fish;

@SpringBootApplication
public class CitygameApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CitygameApplication.class, args);

	}

	/* Implementing CommandLineRunner and testing the	*/
	/* behavior of this application with code below		*/

	@Override
	public void run(String... args) throws Exception {
		startGameSimulation();
	}

	private void startGameSimulation() {
		
		ArrayList<FarmerHouse> FarmerHouseList = new ArrayList<>();
		Fish fish = new Fish();
		
		FarmerHouse fh = new FarmerHouse(fish);

	}

}
