package ro.iss.guruclinic.services.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import ro.iss.guruclinic.model.Owner;
import ro.iss.guruclinic.services.OwnerService;
import ro.iss.guruclinic.services.PetService;
import ro.iss.guruclinic.services.PetTypeService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

  private final PetTypeService petTypeService;
  private final PetService petService;

  public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
    this.petTypeService = petTypeService;
    this.petService = petService;
  }

  @Override
  public Owner save(Owner obj) {
    if (obj != null) {
      if (obj.getPets() != null) {
        obj.getPets()
            .forEach(
                pet -> {
                  if (pet.getPetType() != null) {
                    if (pet.getPetType().getId() == null) {
                      pet.setPetType(petTypeService.save(pet.getPetType()));
                    }
                  } else {
                    throw new RuntimeException("Pet type is required");
                  }

                  if (pet.getId() == null) {
                    petService.save(pet);
                  }
                });
      }
      return super.save(obj);
    }
    return null;
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

  @Override
  public Owner findByLastName(String lastName) {
    return null;
  }
}
