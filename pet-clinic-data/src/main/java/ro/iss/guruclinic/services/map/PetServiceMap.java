package ro.iss.guruclinic.services.map;

import java.util.Set;
import ro.iss.guruclinic.model.Pet;
import ro.iss.guruclinic.services.CrudService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

  @Override
  public Pet save(Pet obj) {
    return super.save(obj.getId(), obj);
  }

  @Override
  public Set<Pet> findAll() {
    return super.findAll();
  }

  @Override
  public Pet findById(Long id) {
    return super.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Pet obj) {
    super.delete(obj);
  }
}
