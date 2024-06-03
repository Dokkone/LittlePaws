package com.rijai.users.repository;

import com.rijai.users.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository <Pet, Integer> {



}
