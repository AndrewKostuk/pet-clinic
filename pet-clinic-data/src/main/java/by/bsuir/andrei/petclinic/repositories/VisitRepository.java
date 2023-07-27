package by.bsuir.andrei.petclinic.repositories;

import by.bsuir.andrei.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
