package pl.dominisz.springpetcliniclite.owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {
  Owner save(Owner owner);

  List<Owner> findAll();

  Optional<Owner> findById(Integer id);

  List<Owner> findByLastName(String lastName);
}
