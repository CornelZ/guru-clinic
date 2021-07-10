package ro.iss.guruclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ro.iss.guruclinic.model.Vet;
import ro.iss.guruclinic.repositories.VetRepository;
import ro.iss.guruclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

  private final VetRepository vetRepository;

  public VetSDJpaService(VetRepository vetRepository) {
    this.vetRepository = vetRepository;
  }

  @Override
  public Set<Vet> findAll() {
    Set<Vet> vets = new HashSet<>();
    vetRepository.findAll().forEach(vets::add);
    return vets;
  }

  @Override
  public Vet findById(Long id) {
    return vetRepository.findById(id).orElse(null);
  }

  @Override
  public Vet save(Vet obj) {
    return vetRepository.save(obj);
  }

  @Override
  public void delete(Vet obj) {
    vetRepository.delete(obj);
  }

  @Override
  public void deleteById(Long id) {
    vetRepository.deleteById(id);
  }
}
