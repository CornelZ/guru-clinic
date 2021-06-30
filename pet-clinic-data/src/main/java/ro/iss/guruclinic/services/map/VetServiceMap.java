package ro.iss.guruclinic.services.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import ro.iss.guruclinic.model.Vet;
import ro.iss.guruclinic.services.SpecialtyService;
import ro.iss.guruclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

  private final SpecialtyService specialtyService;

  public VetServiceMap(SpecialtyService specialtyService) {
    this.specialtyService = specialtyService;
  }

  @Override
  public Vet save(Vet obj) {
    if (obj.getSpecialties().size() >= 0) {
      obj.getSpecialties()
          .forEach(
              spec -> {
                if (spec.getId() == null) {
                  specialtyService.save(spec);
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
