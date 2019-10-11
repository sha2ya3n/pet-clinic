package sha2ya3n.the2gen3tel4man.petclinic.bootstrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sha2ya3n.the2gen3tel4man.petclinic.model.*;
import sha2ya3n.the2gen3tel4man.petclinic.services.OwnerService;
import sha2ya3n.the2gen3tel4man.petclinic.services.PetTypeService;
import sha2ya3n.the2gen3tel4man.petclinic.services.SpecialityService;
import sha2ya3n.the2gen3tel4man.petclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    // we should use constructor like below if and only if we did not specify the Service implementation as Service Component and they are just normal class

//    public DataLoader(){
//        ownerService = new OwnerServiceImpl();
//        vetService = new VetServiceImpl();
//    }

    // we should use constructor if and only if we implement the service as Service not a normal class that means
    // that means we should use @Service annotation and after that can use constructor like down not like up
    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int countNum = petTypeService.findAll().size();

        if(countNum == 0){
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType petTypeDogService = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType petTypeCatService = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialityService.save(radiology);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentist");
        Specialty savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Shayan");
        owner1.setLastName("Khademian");
        owner1.setAddress("123 small health");
        owner1.setCity("Birmangam");

        Pet shayansPet = new Pet();
        shayansPet.setPetType(dog);
        shayansPet.setBirthDate(LocalDate.now());
        shayansPet.setOwner(owner1);
        shayansPet.setName("popet");
        owner1.getPets().add(shayansPet);

        ownerService.save(owner1);

        System.out.println("Setting up owners with their Pet and their type is now done");

        // owner number 2

        Owner owner2 = new Owner();
        owner2.setFirstName("Shina");
        owner2.setLastName("Behmani");
        owner2.setAddress("45 north small health");
        owner2.setCity("birmangam");
        owner2.setTelephone("123563667");

        Pet shinasCat = new Pet();
        shinasCat.setName("rosky");
        shinasCat.setOwner(owner2);
        shinasCat.setBirthDate(LocalDate.now().plusDays(1));
        shinasCat.setPetType(cat);
        owner2.getPets().add(shinasCat);

        ownerService.save(owner2);

        System.out.println("Setting up owners with their Pet and their type is now done");

        Vet vet1 = new Vet();
        vet1.setFirstName("pedram");
        vet1.setLastName("baghayi");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("ali");
        vet2.setLastName("Nakhai");
        vet2.getSpecialties().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("The vet are save well as well");
    }
}
