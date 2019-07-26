package pl.dominisz.springpetcliniclite.owner;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

  private final OwnerRepository ownerRepository;
  private final OwnerConverter ownerConverter;

  public OwnerServiceImpl(OwnerRepository ownerRepository, OwnerConverter ownerConverter) {
    this.ownerRepository = ownerRepository;
    this.ownerConverter = ownerConverter;
  }

  @Override
  public OwnerResponse save(CreateOwnerRequest createOwnerRequest) {
    if (ownerRepository.existsByTelephone(createOwnerRequest.getTelephone())) {
      throw new RuntimeException(
          "Owner with telephone " + createOwnerRequest.getTelephone() + " already exists");
    }

    return ownerConverter.convert(ownerRepository.save(ownerConverter.convert(createOwnerRequest)));
  }

  @Override
  public List<OwnerResponse> findAll() {
    return ownerConverter.convert(ownerRepository.findAll());
  }

  @Override
  public Optional<OwnerResponse> findById(Integer id) {
    return ownerRepository.findById(id).map(ownerConverter::convert);
  }

  @Override
  public List<OwnerResponse> findByLastName(String lastName) {
    return ownerConverter.convert(ownerRepository.findByLastNameContaining(lastName));
  }
}
