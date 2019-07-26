package pl.dominisz.springpetcliniclite.pet;

import pl.dominisz.springpetcliniclite.visit.Visit;
import pl.dominisz.springpetcliniclite.owner.Owner;
import pl.dominisz.springpetcliniclite.pettype.PetType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pets")
public class Pet {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "birth_date")
  @Temporal(TemporalType.DATE)
  private Date birthDate;

  @ManyToOne
  @JoinColumn(name = "type_id")
  private PetType type;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private Owner owner;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet", fetch = FetchType.EAGER)
  private List<Visit> visits;
}
