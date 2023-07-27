package by.bsuir.andrei.petclinic.repositories;

import by.bsuir.andrei.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends CrudRepository<Vet, Long> {
}
