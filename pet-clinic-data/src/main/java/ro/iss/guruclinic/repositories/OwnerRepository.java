package ro.iss.guruclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ro.iss.guruclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
  Owner findByLastName(String lastName);
}
