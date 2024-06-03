package com.example.littlepaws.holder;

import com.example.littlepaws.model.Pet;

public class PetDataHolder {

    private static PetDataHolder instance;
    private Pet savedPet;

    private PetDataHolder() {
        // Private constructor to prevent instantiation
    }

    public static synchronized PetDataHolder getInstance() {
        if (instance == null) {
            instance = new PetDataHolder();
        }
        return instance;
    }

    public Pet getSavedPet() {
        return savedPet;
    }

    public void setSavedPet(Pet pet) {
        savedPet = pet;
    }

}
