package by.bsuir.andrei.petclinic.bootstrap;

import by.bsuir.andrei.petclinic.model.Owner;
import by.bsuir.andrei.petclinic.model.Vet;
import by.bsuir.andrei.petclinic.services.OwnerService;
import by.bsuir.andrei.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("ao");
        owner1.setLastName("aao");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("bo");
        owner2.setLastName("bbo");
        ownerService.save(owner2);

        System.out.println("new owners have been saved");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("av");
        vet1.setLastName("aav");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("bv");
        vet2.setLastName("bbv");
        vetService.save(vet2);

        System.out.println("new vets have been saved");
    }
}
