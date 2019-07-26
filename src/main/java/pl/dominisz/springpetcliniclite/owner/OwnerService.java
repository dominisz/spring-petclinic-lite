package pl.dominisz.springpetcliniclite.owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {
  OwnerResponse save(CreateOwnerRequest owner);

  List<OwnerResponse> findAll();

  Optional<OwnerResponse> findById(Integer id);

  List<OwnerResponse> findByLastName(String lastName);
}
