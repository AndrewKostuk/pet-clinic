package by.bsuir.andrei.petclinic.services.springdatajpa;

import by.bsuir.andrei.petclinic.model.Owner;
import by.bsuir.andrei.petclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    private static final String LAST_NAME = "LastName";

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        Owner byId = ownerSDJpaService.findById(1L);
        assertNotNull(byId);
        assertEquals(1L, byId.getId());
    }

    @Test
    void findByIdNull() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = ownerSDJpaService.findById(1L);
        assertNull(owner);
    }

    @Test
    void findAll() {
        Set<Owner> set = new HashSet<>();
        set.add(Owner.builder().id(1L).lastName("LastName1").build());
        set.add(Owner.builder().id(2L).lastName("LastName2").build());

        when(ownerRepository.findAll()).thenReturn(set);
        Set<Owner> all = ownerSDJpaService.findAll();
        assertNotNull(all);
        assertEquals(2, all.size());
    }

    @Test
    void save() {
        Owner ownerForSave = Owner.builder().id(3L).lastName("LastName3").build();
        when(ownerRepository.save(any(Owner.class))).thenReturn(owner);

        Owner save = ownerSDJpaService.save(ownerForSave);
        assertNotNull(save);
        assertEquals(1L, save.getId());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(owner);
        verify(ownerRepository).delete(any(Owner.class));
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(anyString())).thenReturn(Optional.of(owner));
        Owner byLastName = ownerSDJpaService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, byLastName.getLastName());
    }
}