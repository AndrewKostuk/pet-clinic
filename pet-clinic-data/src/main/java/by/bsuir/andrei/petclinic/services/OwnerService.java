package by.bsuir.andrei.petclinic.services;

import by.bsuir.andrei.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(Long id);

    Set<Owner> findAll();

    Owner save(Owner owner);

    Owner findByLastName(String lastName);
}
