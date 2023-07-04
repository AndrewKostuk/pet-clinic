package by.bsuir.andrei.petclinic.bootstrap;

import by.bsuir.andrei.petclinic.model.Owner;
import by.bsuir.andrei.petclinic.model.PetType;
import by.bsuir.andrei.petclinic.model.Vet;
import by.bsuir.andrei.petclinic.services.OwnerService;
import by.bsuir.andrei.petclinic.services.PetTypeService;
import by.bsuir.andrei.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
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
        owner1.setFirstName("ao");
        owner1.setLastName("aao");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("bo");
        owner2.setLastName("bbo");
        ownerService.save(owner2);

        System.out.println("new owners have been saved");

        Vet vet1 = new Vet();
        vet1.setFirstName("av");
        vet1.setLastName("aav");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("bv");
        vet2.setLastName("bbv");
        vetService.save(vet2);

        System.out.println("new vets have been saved");
    }
}
