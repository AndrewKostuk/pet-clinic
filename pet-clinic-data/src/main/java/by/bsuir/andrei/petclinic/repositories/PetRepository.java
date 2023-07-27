package by.bsuir.andrei.petclinic.repositories;

import by.bsuir.andrei.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
}
