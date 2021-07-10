package ro.iss.guruclinic.services.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import ro.iss.guruclinic.model.Visit;
import ro.iss.guruclinic.services.VisitService;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

  @Override
  public Set<Visit> findAll() {
    return super.findAll();
  }

  @Override
  public Visit findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Visit save(Visit obj) {
    if (obj.getPet() == null || obj.getPet().getOwner() == null || obj.getPet().getId() == null) {
      throw new RuntimeException("Invalid Visit");
    }
    return super.save(obj);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Visit obj) {
    super.delete(obj);
  }
}
