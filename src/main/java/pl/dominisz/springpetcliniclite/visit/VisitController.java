package pl.dominisz.springpetcliniclite.visit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitController {

  private final VisitService visitService;

  public VisitController(VisitService visitService) {
    this.visitService = visitService;
  }

  @PostMapping("/visits")
  public ResponseEntity<VisitResponse> save(@RequestBody CreateVisitRequest createVisitRequest) {
    return ResponseEntity.ok(visitService.save(createVisitRequest));
  }

  @GetMapping("/pets/{petId}/visits")
  public ResponseEntity<List<VisitResponse>> findByPetId(@PathVariable Integer petId) {
    return ResponseEntity.ok(visitService.findByPetId(petId));
  }
}
