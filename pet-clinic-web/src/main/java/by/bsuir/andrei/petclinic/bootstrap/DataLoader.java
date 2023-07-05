package by.bsuir.andrei.petclinic.bootstrap;

import by.bsuir.andrei.petclinic.model.Owner;
import by.bsuir.andrei.petclinic.model.Pet;
import by.bsuir.andrei.petclinic.model.PetType;
import by.bsuir.andrei.petclinic.model.Vet;
import by.bsuir.andrei.petclinic.services.OwnerService;
import by.bsuir.andrei.petclinic.services.PetTypeService;
import by.bsuir.andrei.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("owner1FN");
        owner1.setLastName("owner1LN");
        owner1.setAddress("owner1address");
        owner1.setCity("owner1city");
        owner1.setTelephone("owner1phone");
        Pet pet1 = new Pet();
        pet1.setName("owner1dog");
        pet1.setPetType(savedDogPetType);
        pet1.setBirthDate(LocalDate.now());
        pet1.setOwner(owner1);
        owner1.getPets().add(pet1);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("owner2FN");
        owner2.setLastName("owner2LN");
        owner2.setAddress("owner2address");
        owner2.setCity("owner2city");
        owner2.setTelephone("owner2phone");
        Pet pet2 = new Pet();
        pet2.setName("owner2cat");
        pet2.setPetType(savedCatPetType);
        pet2.setBirthDate(LocalDate.now());
        pet2.setOwner(owner2);
        owner2.getPets().add(pet2);
        ownerService.save(owner2);

        System.out.println("new owners have been saved");

        Vet vet1 = new Vet();
        vet1.setFirstName("vet1FN");
        vet1.setLastName("vet1LN");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("vet2FN");
        vet2.setLastName("vet2LN");
        vetService.save(vet2);

        System.out.println("new vets have been saved");
    }
}
