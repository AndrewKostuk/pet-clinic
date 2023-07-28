package by.bsuir.andrei.petclinic.bootstrap;

import by.bsuir.andrei.petclinic.model.*;
import by.bsuir.andrei.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialityService specialityService,
                      VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
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
        Visit visit1 = new Visit();
        visit1.setDate(LocalDate.now());
        visit1.setDescription("his leg hurts");
        visit1.setPet(pet1);
        pet1.getVisits().add(visit1);
        ownerService.save(owner1);
        visitService.save(visit1);

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
        Visit visit2 = new Visit();
        visit2.setDate(LocalDate.now());
        visit2.setDescription("his stomac hurts");
        visit2.setPet(pet2);
        pet2.getVisits().add(visit2);
        ownerService.save(owner2);
        visitService.save(visit2);

        System.out.println("new owners have been saved");
        System.out.println("new visits have been saved");

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("vet1FN");
        vet1.setLastName("vet1LN");
        vet1.getSpecialities().add(savedDentistry);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("vet2FN");
        vet2.setLastName("vet2LN");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("new vets have been saved");
    }
}
