package ro.iss.guruclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ro.iss.guruclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {}
