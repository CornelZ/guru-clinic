package ro.iss.guruclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ro.iss.guruclinic.model.PetType;
import ro.iss.guruclinic.repositories.PetTypeRepository;
import ro.iss.guruclinic.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

  private final PetTypeRepository petTypeRepository;

  public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
    this.petTypeRepository = petTypeRepository;
  }

  @Override
  public Set<PetType> findAll() {
    Set<PetType> petTypes = new HashSet<>();
    petTypeRepository.findAll().forEach(petTypes::add);
    return petTypes;
  }

  @Override
  public PetType findById(Long id) {
    return petTypeRepository.findById(id).orElse(null);
  }

  @Override
  public PetType save(PetType obj) {
    return petTypeRepository.save(obj);
  }

  @Override
  public void delete(PetType obj) {
    petTypeRepository.delete(obj);
  }

  @Override
  public void deleteById(Long id) {
    petTypeRepository.deleteById(id);
  }
}
