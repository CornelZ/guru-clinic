package ro.iss.guruclinic.boostrap;

import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.iss.guruclinic.model.Owner;
import ro.iss.guruclinic.model.Pet;
import ro.iss.guruclinic.model.PetType;
import ro.iss.guruclinic.model.Specialty;
import ro.iss.guruclinic.model.Vet;
import ro.iss.guruclinic.model.Visit;
import ro.iss.guruclinic.services.OwnerService;
import ro.iss.guruclinic.services.PetTypeService;
import ro.iss.guruclinic.services.SpecialityService;
import ro.iss.guruclinic.services.VetService;
import ro.iss.guruclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;
  private final SpecialityService specialityService;
  private final VisitService visitService;

  public DataLoader(
      OwnerService ownerService,
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
    if (petTypeService.findAll().size() == 0) {
      loadData();
    }
  }

  private void loadData() {
    PetType dog = new PetType();
    dog.setName("Dog");
    petTypeService.save(dog);

    PetType cat = new PetType();
    cat.setName("cat");
    petTypeService.save(cat);

    Specialty radiology = new Specialty();
    radiology.setDescription("Radiology");
    specialityService.save(radiology);

    Specialty surgery = new Specialty();
    surgery.setDescription("Surgery");
    specialityService.save(surgery);

    Specialty dentistry = new Specialty();
    dentistry.setDescription("Dentistry");
    specialityService.save(dentistry);

    Owner owner1 = new Owner();
    owner1.setFirstName("Michael");
    owner1.setLastName("Weston");
    owner1.setAddress("Strada Libertatii");
    owner1.setCity("Braila");
    owner1.setTelephone("112233");

    Pet mikesPet = new Pet();
    mikesPet.setPetType(dog);
    mikesPet.setOwner(owner1);
    mikesPet.setBirthDate(LocalDate.now());
    mikesPet.setName("Rosco");

    owner1.getPets().add(mikesPet);
    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setFirstName("Fiona");
    owner2.setLastName("Glenanne");
    owner2.setAddress("Intrare mosului");
    owner2.setCity("Bucicuresti");
    owner2.setTelephone("998877");

    Pet fionasPet = new Pet();
    fionasPet.setPetType(cat);
    fionasPet.setOwner(owner2);
    fionasPet.setBirthDate(LocalDate.now());
    fionasPet.setName("Kitty");

    owner2.getPets().add(fionasPet);
    ownerService.save(owner2);

    Visit catVisit = new Visit();
    catVisit.setPet(fionasPet);
    catVisit.setDate(LocalDate.now());
    catVisit.setDescription("Sneezy kitty");
    visitService.save(catVisit);

    System.out.println("Loaded Owners....");

    Vet vet1 = new Vet();
    vet1.setFirstName("Sam");
    vet1.setLastName("Axe");
    vet1.getSpecialities().add(radiology);
    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setFirstName("Jessie");
    vet2.setLastName("Porter");
    vet2.getSpecialities().add(surgery);
    vetService.save(vet2);

    System.out.println("Loaded Vets....");
  }
}
