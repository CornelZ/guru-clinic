package ro.iss.guruclinic.services;

import ro.iss.guruclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

  public Owner findByLastName(String lastName);
}
