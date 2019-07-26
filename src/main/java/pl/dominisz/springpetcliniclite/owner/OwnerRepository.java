package pl.dominisz.springpetcliniclite.owner;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {

  boolean existsByTelephone(String telephone);
  List<Owner> findByLastNameContaining(String lastName);
}
