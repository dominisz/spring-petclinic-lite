package pl.dominisz.springpetcliniclite.pet;

public interface PetService {
  PetResponse save(CreatePetRequest createPetRequest);
}
