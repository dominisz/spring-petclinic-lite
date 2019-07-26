package pl.dominisz.springpetcliniclite.pet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

  private final PetService petService;

  public PetController(PetService petService) {
    this.petService = petService;
  }

  @PostMapping
  public ResponseEntity<PetResponse> save(@RequestBody CreatePetRequest createPetRequest) {
    return ResponseEntity.ok(petService.save(createPetRequest));
  }

  @GetMapping
  public ResponseEntity<List<PetResponse>> findAll() {
    return ResponseEntity.ok(petService.findAll());
  }
}
