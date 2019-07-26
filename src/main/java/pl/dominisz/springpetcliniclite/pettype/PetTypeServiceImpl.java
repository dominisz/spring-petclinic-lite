package pl.dominisz.springpetcliniclite.pettype;

import org.springframework.stereotype.Service;
import pl.dominisz.springpetcliniclite.exception.DuplicatedResourceException;

import java.util.List;
import java.util.Optional;

@Service
public class PetTypeServiceImpl implements PetTypeService {

  private final PetTypeRepository petTypeRepository;

  public PetTypeServiceImpl(PetTypeRepository petTypeRepository) {
    this.petTypeRepository = petTypeRepository;
  }

  @Override
  public PetType save(PetType petType) {
    if (petTypeRepository.existsByName(petType.getName())) {
      throw new DuplicatedResourceException(
          "Pet type with name " + petType.getName() + " already exists");
    }
    return petTypeRepository.save(petType);
  }

  @Override
  public Optional<PetType> findById(Integer id) {
    return petTypeRepository.findById(id);
  }

  @Override
  public List<PetType> findAll() {
    return petTypeRepository.findAll();
  }
}
