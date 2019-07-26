package pl.dominisz.springpetcliniclite.owner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerResponse {

  private Integer id;
  private String firstName;
  private String lastName;
  private String address;
  private String city;
  private String telephone;
}
