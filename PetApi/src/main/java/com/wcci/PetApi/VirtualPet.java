package com.wcci.PetApi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "virtual_pet")
@Entity(name = "virtual_pet")

public class VirtualPet {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String breed;
    private int hunger;
    private int thirst;
    private int happiness;

    public VirtualPet() {
        // Default empty constructor necessary for Spring Boot.
    }

    public VirtualPet(String name, String breed, int hunger, int thirst, int happiness) {
        this.name = name;
        this.breed = breed;
        this.hunger = hunger;
        this.thirst = thirst;
        this.happiness = happiness;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getBreed() {
        return breed;
    }
    public int getHunger() {
        return hunger;
    }
    public int getThirst() {
        return thirst;
    }
    public int getHappiness() {
        return happiness;
    }
}
