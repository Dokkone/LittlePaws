package com.rijai.users.services;

import com.rijai.users.model.Pet;
import com.rijai.users.model.User;
import com.rijai.users.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService implements IPetService{
    @Autowired
    private PetRepository petRepository;

    public List<Pet> getAllPets()
    {
        List<Pet>petRecords = new ArrayList<>();
        petRepository.findAll().forEach(petRecords::add);
        return petRecords;
    }

    public Pet addPet(Pet pet)
    {
        return petRepository.save(pet);
    }

    public Pet getPet(int id) {
        Optional optional=petRepository.findById(id);
        if(optional.isEmpty())
            return null;
        else
            return (Pet)optional.get();
    }

    public Pet updatePet(int id) {
        Optional<Pet> pet = petRepository.findById(id);
        if(pet.isPresent()) {
            return petRepository.save(pet.get());
        }
        else
            return null;
    }

    public Pet deletePet(int id)
    {
        Optional<Pet> pet = petRepository.findById(id);
        if(pet.isPresent()) {
            petRepository.delete(pet.get());
        }
        return null;

    }

}
