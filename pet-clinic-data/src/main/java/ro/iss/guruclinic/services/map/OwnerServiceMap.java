package ro.iss.guruclinic.services.map;

import java.util.Set;
import ro.iss.guruclinic.model.Owner;
import ro.iss.guruclinic.services.CrudService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long>
    implements CrudService<Owner, Long> {

  @Override
  public Owner save(Owner obj) {
    return super.save(obj.getId(), obj);
  }

  @Override
  public Set<Owner> findAll() {
    return super.findAll();
  }

  @Override
  public Owner findById(Long id) {
    return super.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Owner obj) {
    super.delete(obj);
  }
}
