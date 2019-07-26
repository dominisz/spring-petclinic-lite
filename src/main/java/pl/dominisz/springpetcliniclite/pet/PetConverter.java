package pl.dominisz.springpetcliniclite.pet;

import org.springframework.stereotype.Component;
import pl.dominisz.springpetcliniclite.owner.OwnerConverter;

@Component
public class PetConverter {

  private final OwnerConverter ownerConverter;

  public PetConverter(OwnerConverter ownerConverter) {
    this.ownerConverter = ownerConverter;
  }

  public PetResponse convert(Pet pet) {
    PetResponse response = new PetResponse();

    response.setId(pet.getId());
    response.setName(pet.getName());
    response.setBirthDate(pet.getBirthDate());
    response.setType(pet.getType());
    response.setOwner(ownerConverter.convert(pet.getOwner()));

    return response;
  }
}
