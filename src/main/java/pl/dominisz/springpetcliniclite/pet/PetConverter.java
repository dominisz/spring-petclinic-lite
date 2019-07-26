package pl.dominisz.springpetcliniclite.pet;

import org.springframework.stereotype.Component;
import pl.dominisz.springpetcliniclite.owner.OwnerConverter;

import java.util.List;
import java.util.stream.Collectors;

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

  public List<PetResponse> convert(List<Pet> pets) {
    return pets.stream().map(this::convert).collect(Collectors.toList());
  }
}
