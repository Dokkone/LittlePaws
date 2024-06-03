package com.rijai.users.services;

import com.rijai.users.model.Pet;

import java.util.List;

public interface IPetService {

    List<Pet> getAllPets();

    Pet addPet(Pet pet);

    Pet updatePet(int id);

    Pet getPet(int id);

    Pet deletePet(int id);

}
