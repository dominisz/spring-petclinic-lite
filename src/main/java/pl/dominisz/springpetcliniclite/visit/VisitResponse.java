package pl.dominisz.springpetcliniclite.visit;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VisitResponse {
  private Integer id;
  private Date date;
  private String description;
}
