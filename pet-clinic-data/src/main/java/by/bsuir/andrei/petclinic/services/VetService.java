package by.bsuir.andrei.petclinic.services;

import by.bsuir.andrei.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Set<Vet> findAll();

    Vet save(Vet vet);
}
