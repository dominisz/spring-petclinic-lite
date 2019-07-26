package pl.dominisz.springpetcliniclite.owner;

import lombok.Getter;
import lombok.Setter;
import pl.dominisz.springpetcliniclite.pet.Pet;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")
@Getter
@Setter
public class Owner {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "address")
  private String address;

  @Column(name = "city")
  private String city;

  @Column(name = "telephone")
  private String telephone;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.EAGER)
  private List<Pet> pets = new ArrayList<>();
}
