package pl.dominisz.springpetcliniclite.pet;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreatePetRequest {

  private String name;
  private Date birthDate;
  private Integer petTypeId;
  private Integer ownerId;
}
