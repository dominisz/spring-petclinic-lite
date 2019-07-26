package pl.dominisz.springpetcliniclite.visit;

import pl.dominisz.springpetcliniclite.pet.Pet;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visits")
public class Visit {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "visit_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date date;

  @Column(name = "description")
  private String description;

  @ManyToOne
  @JoinColumn(name = "pet_id")
  private Pet pet;
}
