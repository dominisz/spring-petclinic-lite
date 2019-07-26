package pl.dominisz.springpetcliniclite.visit;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VisitConverter {

  public VisitResponse convert(Visit visit) {
    VisitResponse response = new VisitResponse();

    response.setId(visit.getId());
    response.setDate(visit.getDate());
    response.setDescription(visit.getDescription());

    return response;
  }

  public List<VisitResponse> convert(List<Visit> visits) {
    return visits.stream().map(this::convert).collect(Collectors.toList());
  }
}
