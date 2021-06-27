package ro.iss.guruclinic.services;

import java.util.Set;
import ro.iss.guruclinic.model.Owner;

public interface OwnerService {

  public Owner findByLastName(String lastName);

  public Owner findByID(Long id);

  public Owner save(Owner owner);

  public Set<Owner> findAll();
}
