package pl.dominisz.springpetcliniclite.pettype;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pettypes")
public class PetTypeController {

  private final PetTypeService petTypeService;

  public PetTypeController(PetTypeService petTypeService) {
    this.petTypeService = petTypeService;
  }

  @PostMapping
  public ResponseEntity<PetType> save(@RequestBody PetType petType) {
    return ResponseEntity.ok(petTypeService.save(petType));
  }

  @GetMapping("/{id}")
  public ResponseEntity<PetType> findById(@PathVariable Integer id) {
    return ResponseEntity.of(petTypeService.findById(id));
  }

  @GetMapping
  public ResponseEntity<List<PetType>> findAll() {
    return ResponseEntity.ok(petTypeService.findAll());
  }
}
