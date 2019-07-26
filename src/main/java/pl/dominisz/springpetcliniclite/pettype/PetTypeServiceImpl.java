package pl.dominisz.springpetcliniclite.pettype;

import org.springframework.stereotype.Service;

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
    if (!petTypeRepository.existsByName(petType.getName())) {
      return petTypeRepository.save(petType);
    }
    throw new RuntimeException("PetType " + petType.getName() + " already exists");
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
