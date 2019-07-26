package pl.dominisz.springpetcliniclite.visit;

import org.springframework.stereotype.Service;
import pl.dominisz.springpetcliniclite.pet.Pet;
import pl.dominisz.springpetcliniclite.pet.PetRepository;

import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

  private final VisitRepository visitRepository;
  private final PetRepository petRepository;
  private final VisitConverter visitConverter;

  public VisitServiceImpl(
      VisitRepository visitRepository, PetRepository petRepository, VisitConverter visitConverter) {
    this.visitRepository = visitRepository;
    this.petRepository = petRepository;
    this.visitConverter = visitConverter;
  }

  @Override
  public VisitResponse save(CreateVisitRequest createVisitRequest) {
    Pet pet = findPet(createVisitRequest.getPetId());

    Visit visit = new Visit();
    visit.setDate(createVisitRequest.getDate());
    visit.setDescription(createVisitRequest.getDescription());
    visit.setPet(pet);

    pet.getVisits().add(visit);

    return visitConverter.convert(visitRepository.save(visit));
  }

  @Override
  public List<VisitResponse> findByPetId(Integer petId) {
    Pet pet = findPet(petId);

    return visitConverter.convert(pet.getVisits());
  }

  private Pet findPet(Integer petId) {
    return petRepository.findById(petId).orElseThrow(() -> new RuntimeException("Pet not found"));
  }
}
