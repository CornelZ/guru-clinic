package ro.iss.guruclinic.services.map;

import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ro.iss.guruclinic.model.Vet;
import ro.iss.guruclinic.services.SpecialityService;
import ro.iss.guruclinic.services.VetService;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

  private final SpecialityService specialityService;

  public VetMapService(SpecialityService specialityService) {
    this.specialityService = specialityService;
  }

  @Override
  public Vet save(Vet obj) {
    if (obj.getSpecialities().size() >= 0) {
      obj.getSpecialities()
          .forEach(
              spec -> {
                if (spec.getId() == null) {
                  specialityService.save(spec);
                }
              });
    }
    return super.save(obj);
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
