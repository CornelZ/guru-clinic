package ro.iss.guruclinic.services;

import java.util.Set;
import ro.iss.guruclinic.model.Vet;

public interface VetService {
  public Vet findByID(Long id);

  public Vet save(Vet owner);

  public Set<Vet> findAll();
}
