package ro.iss.guruclinic.services.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import ro.iss.guruclinic.model.Specialty;
import ro.iss.guruclinic.services.SpecialtyService;

@Service
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long>
    implements SpecialtyService {

  @Override
  public Specialty save(Specialty obj) {
    return super.save(obj);
  }

  @Override
  public Set<Specialty> findAll() {
    return super.findAll();
  }

  @Override
  public Specialty findById(Long id) {
    return super.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Specialty obj) {
    super.delete(obj);
  }
}
