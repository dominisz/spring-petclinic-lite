package pl.dominisz.springpetcliniclite.pet;

import lombok.Getter;
import lombok.Setter;
import pl.dominisz.springpetcliniclite.owner.OwnerResponse;
import pl.dominisz.springpetcliniclite.pettype.PetType;

import java.util.Date;

@Getter
@Setter
public class PetResponse {

  private Integer id;
  private String name;
  private Date birthDate;
  private PetType type;
  private OwnerResponse owner;
}
