package ro.iss.guruclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ro.iss.guruclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {}
