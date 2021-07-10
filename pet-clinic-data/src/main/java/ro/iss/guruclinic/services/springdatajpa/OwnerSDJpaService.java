package ro.iss.guruclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ro.iss.guruclinic.model.Owner;
import ro.iss.guruclinic.repositories.OwnerRepository;
import ro.iss.guruclinic.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

  private final OwnerRepository ownerRepository;

  public OwnerSDJpaService(OwnerRepository ownerRepository) {
    this.ownerRepository = ownerRepository;
  }

  @Override
  public Set<Owner> findAll() {
    Set<Owner> owners = new HashSet<>();
    ownerRepository.findAll().forEach(owners::add);
    return owners;
  }

  @Override
  public Owner findById(Long id) {
    return ownerRepository.findById(id).orElse(null);
  }

  @Override
  public Owner save(Owner obj) {
    return ownerRepository.save(obj);
  }

  @Override
  public void delete(Owner obj) {
    ownerRepository.delete(obj);
  }

  @Override
  public void deleteById(Long id) {
    ownerRepository.deleteById(id);
  }

  @Override
  public Owner findByLastName(String lastName) {
    return ownerRepository.findByLastName(lastName);
  }
}
