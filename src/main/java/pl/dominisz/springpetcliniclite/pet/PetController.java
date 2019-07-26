package pl.dominisz.springpetcliniclite.pet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
