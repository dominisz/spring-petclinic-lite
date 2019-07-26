package pl.dominisz.springpetcliniclite.pet;

import org.springframework.stereotype.Service;
import pl.dominisz.springpetcliniclite.owner.Owner;
import pl.dominisz.springpetcliniclite.owner.OwnerRepository;
import pl.dominisz.springpetcliniclite.pettype.PetType;
import pl.dominisz.springpetcliniclite.pettype.PetTypeRepository;

@Service
public class PetServiceImpl implements PetService {

  private final PetRepository petRepository;
  private final OwnerRepository ownerRepository;
  private final PetTypeRepository petTypeRepository;
  private final PetConverter petConverter;

  public PetServiceImpl(
      PetRepository petRepository,
      OwnerRepository ownerRepository,
      PetTypeRepository petTypeRepository,
      PetConverter petConverter) {
    this.petRepository = petRepository;
    this.ownerRepository = ownerRepository;
    this.petTypeRepository = petTypeRepository;
    this.petConverter = petConverter;
  }

  @Override
  public PetResponse save(CreatePetRequest createPetRequest) {
    PetType petType = findPetType(createPetRequest.getPetTypeId());
    Owner owner = findOwner(createPetRequest.getOwnerId());
    Pet pet = new Pet();

    pet.setName(createPetRequest.getName());
    pet.setBirthDate(createPetRequest.getBirthDate());
    pet.setType(petType);
    pet.setOwner(owner);

    owner.getPets().add(pet);

    return petConverter.convert(petRepository.save(pet));
  }

  private PetType findPetType(Integer id) {
    return petTypeRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("PetType not found"));
  }

  private Owner findOwner(Integer id) {
    return ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
  }
}
