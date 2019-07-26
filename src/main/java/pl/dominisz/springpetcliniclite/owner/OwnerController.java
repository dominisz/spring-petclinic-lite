package pl.dominisz.springpetcliniclite.owner;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

  private final OwnerService ownerService;

  public OwnerController(OwnerService ownerService) {
    this.ownerService = ownerService;
  }

  @PostMapping
  public ResponseEntity<Owner> save(@RequestBody Owner owner) {
    return ResponseEntity.ok(ownerService.save(owner));
  }

  @GetMapping
  public ResponseEntity<List<Owner>> findAll() {
    return ResponseEntity.ok(ownerService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Owner> findById(@PathVariable Integer id) {
    return ResponseEntity.of(ownerService.findById(id));
  }

  @GetMapping("/lastname/{lastName}")
  public ResponseEntity<List<Owner>> findByLastName(@PathVariable String lastName) {
    return ResponseEntity.ok(ownerService.findByLastName(lastName));
  }
}
