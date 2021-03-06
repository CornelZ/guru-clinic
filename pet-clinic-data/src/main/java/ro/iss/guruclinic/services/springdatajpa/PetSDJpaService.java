package ro.iss.guruclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ro.iss.guruclinic.model.Pet;
import ro.iss.guruclinic.repositories.PetRepository;
import ro.iss.guruclinic.services.PetService;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

  private final PetRepository petRepository;

  public PetSDJpaService(PetRepository petRepository) {
    this.petRepository = petRepository;
  }

  @Override
  public Set<Pet> findAll() {
    Set<Pet> pets = new HashSet<>();
    petRepository.findAll().forEach(pets::add);
    return pets;
  }

  @Override
  public Pet findById(Long id) {
    return petRepository.findById(id).orElse(null);
  }

  @Override
  public Pet save(Pet obj) {
    return petRepository.save(obj);
  }

  @Override
  public void delete(Pet obj) {
    petRepository.delete(obj);
  }

  @Override
  public void deleteById(Long id) {
    petRepository.deleteById(id);
  }
}
