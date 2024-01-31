package com.example.citygame;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.citygame.model.houses.FarmerHouse;
import com.example.citygame.model.productionbuildings.Fishery;

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
		startGameSimulation();
	}

	private void startGameSimulation() {

		ArrayList<FarmerHouse> farmerHouseList = new ArrayList<>();

		FarmerHouse fh = new FarmerHouse();
		farmerHouseList.add(fh);
		Fishery fih = new Fishery();

		Scanner s = new Scanner(System.in);

		while (true) {
			System.out.println("""
					Select an action :

					1- Add farmer house
					2- Add fishery
					""");

			String command = s.nextLine();

			switch (command) {
				case "1":

					fh = new FarmerHouse();
					farmerHouseList.add(fh);

					break;
			
				default:
					break;
			}

		}

	}

}
