package pl.dominisz.springpetcliniclite.pettype;

import java.util.List;
import java.util.Optional;

public interface PetTypeService {
  PetType save(PetType petType);

  Optional<PetType> findById(Integer id);

  List<PetType> findAll();
}
