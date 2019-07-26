package pl.dominisz.springpetcliniclite.pettype;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pettypes")
@Getter
@Setter
public class PetType {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;
}
