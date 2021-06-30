package ro.iss.guruclinic.services.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import ro.iss.guruclinic.model.PetType;
import ro.iss.guruclinic.services.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

  @Override
  public PetType save(PetType obj) {
    return super.save(obj);
  }

  @Override
  public Set<PetType> findAll() {
    return super.findAll();
  }

  @Override
  public PetType findById(Long id) {
    return super.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(PetType obj) {
    super.delete(obj);
  }
}
