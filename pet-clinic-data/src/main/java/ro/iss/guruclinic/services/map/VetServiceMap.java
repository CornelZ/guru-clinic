package ro.iss.guruclinic.services.map;

import java.util.Set;
import ro.iss.guruclinic.model.Vet;
import ro.iss.guruclinic.services.CrudService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {

  @Override
  public Vet save(Vet obj) {
    return super.save(obj.getId(), obj);
  }

  @Override
  public Set<Vet> findAll() {
    return super.findAll();
  }

  @Override
  public Vet findById(Long id) {
    return super.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Vet obj) {
    super.delete(obj);
  }
}
