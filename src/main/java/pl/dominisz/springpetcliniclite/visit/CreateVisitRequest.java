package pl.dominisz.springpetcliniclite.visit;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateVisitRequest {

  private Date date;
  private String description;
  private Integer petId;
}
