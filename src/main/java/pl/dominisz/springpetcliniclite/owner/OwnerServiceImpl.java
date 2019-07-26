package pl.dominisz.springpetcliniclite.owner;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

  private final OwnerRepository ownerRepository;

  public OwnerServiceImpl(OwnerRepository ownerRepository) {
    this.ownerRepository = ownerRepository;
  }

  @Override
  public Owner save(Owner owner) {
    if (!ownerRepository.existsByTelephone(owner.getTelephone())) {
      return ownerRepository.save(owner);
    }
    throw new RuntimeException("Owner with telephone " + owner.getTelephone() + " already exists");
  }

  @Override
  public List<Owner> findAll() {
    return ownerRepository.findAll();
  }

  @Override
  public Optional<Owner> findById(Integer id) {
    return ownerRepository.findById(id);
  }

  @Override
  public List<Owner> findByLastName(String lastName) {
    return ownerRepository.findByLastNameContaining(lastName);
  }
}
