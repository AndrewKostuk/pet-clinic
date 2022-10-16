package by.bsuir.andrei.petclinic.services;

import by.bsuir.andrei.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Set<Pet> findAll();

    Pet save(Pet pet);
}
