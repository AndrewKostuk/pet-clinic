package by.bsuir.andrei.petclinic.repositories;

import by.bsuir.andrei.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
