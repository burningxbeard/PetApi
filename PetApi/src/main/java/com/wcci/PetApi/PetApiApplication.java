package com.wcci.PetApi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(VirtualPetRepository virtualPetRepository) {
		return arg -> {
			VirtualPet crusty = new VirtualPet("Crusty", "French Bulldog", 50, 20, 100);
			virtualPetRepository.save(crusty);

			VirtualPet dusty = new VirtualPet("Dusty", "English Bulldog", 50, 40, 100);
			virtualPetRepository.save(dusty);

			VirtualPet rusty = new VirtualPet("Rusty", "American Bulldog", 20, 10, 10);
			virtualPetRepository.save(rusty);

			VirtualPet steve = new VirtualPet("Steve", "Shi tzu", 100, 100, 0);
			virtualPetRepository.save(steve);
};
	}
}