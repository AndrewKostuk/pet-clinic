package by.bsuir.andrei.petclinic.services.map;

import by.bsuir.andrei.petclinic.model.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final Integer ownerSetSize = 1;
    final Integer emptySetSize = 0;
    final String lastName = "LastName";
    final String incorrectLastName = "foo";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        Assertions.assertEquals(ownerId, owner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> all = ownerMapService.findAll();
        Assertions.assertEquals(ownerSetSize, all.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        Owner owner = ownerMapService.findById(ownerId);
        Assertions.assertNull(owner);
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        Set<Owner> all = ownerMapService.findAll();
        Assertions.assertEquals(emptySetSize, all.size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner save = ownerMapService.save(Owner.builder().id(id).build());
        Assertions.assertEquals(id, save.getId());
    }

    @Test
    void saveNoId() {
        Owner owner = ownerMapService.save(Owner.builder().build());
        Assertions.assertNotNull(owner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);
        Assertions.assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastNameNull() {
        Owner owner = ownerMapService.findByLastName(incorrectLastName);
        Assertions.assertNull(owner);
    }
}