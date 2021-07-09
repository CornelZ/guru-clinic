package ro.iss.guruclinic.services.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import ro.iss.guruclinic.model.Speciality;
import ro.iss.guruclinic.services.SpecialtyService;

@Service
public class SpecialtyServiceMap extends AbstractMapService<Speciality, Long>
    implements SpecialtyService {

  @Override
  public Speciality save(Speciality obj) {
    return super.save(obj);
  }

  @Override
  public Set<Speciality> findAll() {
    return super.findAll();
  }

  @Override
  public Speciality findById(Long id) {
    return super.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Speciality obj) {
    super.delete(obj);
  }
}
