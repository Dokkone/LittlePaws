package com.rijai.users.controller;

import com.rijai.users.model.Pet;
import com.rijai.users.repository.PetRepository;
import com.rijai.users.services.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class PetController {

    private PetService petService;
    private PetRepository petRepository;

    public PetController(PetService petService,PetRepository petRepository)
    {
        this.petService = petService;
        this.petRepository = petRepository;
    }

    @RequestMapping("/api/pets")
    public List<Pet> findPets(){
        return petService.getAllPets();
    }

    @RequestMapping("/api/show-pet/{id}")
    public Pet showPet(@PathVariable int id) {
        return petService.getPet(id);
    }

    @RequestMapping(value="/api/add-pet", method = RequestMethod.POST)
    public Pet addPetSubmit(@RequestBody Pet pet){
        return petService.addPet(pet);
    }

    @RequestMapping(value = "/api/update-pet/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pet> updatePet(@PathVariable int id, @RequestBody Pet updatedPet) {
        Optional<Pet> optionalPet = petRepository.findById(id);

        if (optionalPet.isPresent()) {
            Pet existingPet = optionalPet.get();

            existingPet.setName(updatedPet.getName());
            existingPet.setBreed(updatedPet.getBreed());
            existingPet.setGender(updatedPet.getGender());
            existingPet.setLocation(updatedPet.getLocation());
            existingPet.setDescription(updatedPet.getDescription());
            Pet updated = petRepository.save(existingPet);
            return ResponseEntity.ok(updated);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/api/delete-pet/{id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable int id) {
        petService.deletePet(id);
    }

}
