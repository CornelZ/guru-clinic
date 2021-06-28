package ro.iss.guruclinic.services;

import ro.iss.guruclinic.model.Pet;

public interface PetService extends CrudService<Pet, Long> {

  public Pet findByID(Long id);
}
