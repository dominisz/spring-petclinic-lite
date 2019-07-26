package pl.dominisz.springpetcliniclite.pet;

import java.util.List;

public interface PetService {
  PetResponse save(CreatePetRequest createPetRequest);

  List<PetResponse> findAll();
}
