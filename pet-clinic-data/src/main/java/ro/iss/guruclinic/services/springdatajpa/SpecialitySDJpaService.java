package ro.iss.guruclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ro.iss.guruclinic.model.Specialty;
import ro.iss.guruclinic.repositories.SpecialityRepository;
import ro.iss.guruclinic.services.SpecialityService;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialityService {

  private final SpecialityRepository specialityRepository;

  public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
    this.specialityRepository = specialityRepository;
  }

  @Override
  public Set<Specialty> findAll() {
    Set<Specialty> specialty = new HashSet<>();
    specialityRepository.findAll().forEach(specialty::add);
    return specialty;
  }

  @Override
  public Specialty findById(Long id) {
    return specialityRepository.findById(id).orElse(null);
  }

  @Override
  public Specialty save(Specialty obj) {
    return specialityRepository.save(obj);
  }

  @Override
  public void delete(Specialty obj) {
    specialityRepository.delete(obj);
  }

  @Override
  public void deleteById(Long id) {
    specialityRepository.deleteById(id);
  }
}
