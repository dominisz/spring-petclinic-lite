package pl.dominisz.springpetcliniclite.visit;

import java.util.List;

public interface VisitService {

  VisitResponse save(CreateVisitRequest createVisitRequest);

  List<VisitResponse> findByPetId(Integer petId);
}
