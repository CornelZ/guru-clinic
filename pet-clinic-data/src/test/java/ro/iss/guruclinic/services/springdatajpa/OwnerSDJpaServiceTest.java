package ro.iss.guruclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.iss.guruclinic.model.Owner;
import ro.iss.guruclinic.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

  private static final String LAST_NAME = "Smith";
  private Owner returnOwner;

  @Mock private OwnerRepository ownerRepository;

  @InjectMocks private OwnerSDJpaService ownerSDJpaService;

  @BeforeEach
  void setUp() throws Exception {
    returnOwner = Owner.builder().id(1l).lastName(LAST_NAME).build();
  }

  @Test
  void testFindByLastName() {

    Owner returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    Mockito.when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(returnOwner);

    Owner owner = ownerSDJpaService.findByLastName(LAST_NAME);

    assertEquals(LAST_NAME, owner.getLastName());
    Mockito.verify(ownerRepository).findByLastName(Mockito.any());
  }

  @Test
  void testFindAll() {
    Set<Owner> returnOwnersSet = new HashSet<>();
    returnOwnersSet.add(Owner.builder().id(1l).build());
    returnOwnersSet.add(Owner.builder().id(2l).build());

    Mockito.when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

    Set<Owner> owners = ownerSDJpaService.findAll();

    assertNotNull(owners);
    assertEquals(2, owners.size());
  }

  @Test
  void testFindById() {
    Mockito.when(ownerRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

    Owner owner = ownerSDJpaService.findById(1L);

    assertNull(owner);
  }

  @Test
  void testSave() {
    Owner ownerToSave = Owner.builder().id(1L).build();
    Mockito.when(ownerRepository.save(Mockito.any())).thenReturn(returnOwner);

    Owner savedOwner = ownerSDJpaService.save(ownerToSave);

    assertNotNull(savedOwner);
    Mockito.verify(ownerRepository).save(Mockito.any());
  }

  @Test
  void testDelete() {
    ownerSDJpaService.delete(returnOwner);

    // default is 1 times
    Mockito.verify(ownerRepository, Mockito.times(1)).delete(Mockito.any());
  }

  @Test
  void testDeleteById() {
    ownerSDJpaService.deleteById(1L);
    Mockito.verify(ownerRepository).deleteById(Mockito.anyLong());
  }
}
