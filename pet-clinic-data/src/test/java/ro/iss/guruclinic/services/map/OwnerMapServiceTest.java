package ro.iss.guruclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.iss.guruclinic.model.Owner;
import ro.iss.guruclinic.services.PetService;
import ro.iss.guruclinic.services.PetTypeService;

class OwnerMapServiceTest {

  private static OwnerMapService ownerMapService;
  private static final Long ownerId = 1L;
  private static final String lastName = "Smith";

  @BeforeEach
  void setUp() throws Exception {
    PetTypeService petTypeService = new PetTypeMapService();
    PetService petService = new PetMapService();

    ownerMapService = new OwnerMapService(petTypeService, petService);

    ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
  }

  @Test
  void testFindAll() {
    Set<Owner> ownerSet = ownerMapService.findAll();
    assertEquals(1, ownerSet.size());
  }

  @Test
  void testFindByIdLong() {
    Owner owner = ownerMapService.findById(ownerId);
    assertEquals(ownerId, owner.getId());
  }

  @Test
  void testSaveOwnerExistingId() {
    final Long id = 2L;
    Owner owner = Owner.builder().id(id).build();
    Owner savedOwner = ownerMapService.save(owner);
    assertEquals(id, savedOwner.getId());
  }

  @Test
  void testSaveOwnerNoId() {
    Owner owner = Owner.builder().build();
    Owner savedOwner = ownerMapService.save(owner);
    assertNotNull(savedOwner);
    assertNotNull(savedOwner.getId());
  }

  @Test
  void testDeleteByIdLong() {
    ownerMapService.deleteById(ownerId);
    assertEquals(0, ownerMapService.findAll().size());
  }

  @Test
  void testDeleteOwner() {
    ownerMapService.delete(ownerMapService.findById(ownerId));
    assertEquals(0, ownerMapService.findAll().size());
  }

  @Test
  void testFindByLastName() {
    Owner owner = ownerMapService.findByLastName(lastName);
    assertEquals(ownerId, owner.getId());
    assertEquals(lastName, owner.getLastName());
  }

  @Test
  void testFindByLastNameNotFound() {
    Owner owner = ownerMapService.findByLastName("foo");
    assertNull(owner);
  }
}
