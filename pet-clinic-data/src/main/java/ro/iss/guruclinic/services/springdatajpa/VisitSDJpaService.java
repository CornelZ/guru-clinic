package ro.iss.guruclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ro.iss.guruclinic.model.Visit;
import ro.iss.guruclinic.repositories.VisitRepository;
import ro.iss.guruclinic.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

  private final VisitRepository visitRepository;

  public VisitSDJpaService(VisitRepository visitRepository) {
    this.visitRepository = visitRepository;
  }

  @Override
  public Set<Visit> findAll() {
    Set<Visit> visits = new HashSet<>();
    visitRepository.findAll().forEach(visits::add);
    return visits;
  }

  @Override
  public Visit findById(Long id) {
    return visitRepository.findById(id).orElse(null);
  }

  @Override
  public Visit save(Visit obj) {
    return visitRepository.save(obj);
  }

  @Override
  public void delete(Visit obj) {
    visitRepository.delete(obj);
  }

  @Override
  public void deleteById(Long id) {
    visitRepository.deleteById(id);
  }
}
