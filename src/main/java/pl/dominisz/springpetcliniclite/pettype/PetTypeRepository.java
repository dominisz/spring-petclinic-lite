package pl.dominisz.springpetcliniclite.pettype;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetTypeRepository extends JpaRepository<PetType, Integer> {

  Optional<PetType> findByName(String name);

  boolean existsByName(String name);
}
