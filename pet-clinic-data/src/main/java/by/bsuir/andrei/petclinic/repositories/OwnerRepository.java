package by.bsuir.andrei.petclinic.repositories;

import by.bsuir.andrei.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
