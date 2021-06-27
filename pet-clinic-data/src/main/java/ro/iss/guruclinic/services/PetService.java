package ro.iss.guruclinic.services;

import java.util.Set;
import ro.iss.guruclinic.model.Pet;

public interface PetService {

  public Pet findByID(Long id);

  public Pet save(Pet pet);

  public Set<Pet> findAll();
}
