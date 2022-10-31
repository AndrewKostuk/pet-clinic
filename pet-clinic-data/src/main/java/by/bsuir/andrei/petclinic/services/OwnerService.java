package by.bsuir.andrei.petclinic.services;

import by.bsuir.andrei.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
