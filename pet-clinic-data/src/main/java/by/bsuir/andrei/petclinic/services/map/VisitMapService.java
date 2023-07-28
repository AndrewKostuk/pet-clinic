package by.bsuir.andrei.petclinic.services.map;

import by.bsuir.andrei.petclinic.model.Visit;
import by.bsuir.andrei.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit save(Visit object) {
        if (object == null || object.getPet() == null || object.getPet().getId() == null
                || object.getPet().getPetType() == null || object.getPet().getPetType().getId() == null
                || object.getPet().getOwner() == null || object.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid visit");
        } else {
            return super.save(object);
        }
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
