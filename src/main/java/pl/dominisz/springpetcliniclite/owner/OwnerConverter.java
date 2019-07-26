package pl.dominisz.springpetcliniclite.owner;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OwnerConverter {

  public Owner convert(CreateOwnerRequest createOwnerRequest) {
    Owner owner = new Owner();
    owner.setFirstName(createOwnerRequest.getFirstName());
    owner.setLastName(createOwnerRequest.getLastName());
    owner.setAddress(createOwnerRequest.getAddress());
    owner.setCity(createOwnerRequest.getCity());
    owner.setTelephone(createOwnerRequest.getTelephone());
    return owner;
  }

  public OwnerResponse convert(Owner owner) {
    OwnerResponse response = new OwnerResponse();
    response.setId(owner.getId());
    response.setFirstName(owner.getFirstName());
    response.setLastName(owner.getLastName());
    response.setAddress(owner.getAddress());
    response.setCity(owner.getCity());
    response.setTelephone(owner.getTelephone());
    return response;
  }

  public List<OwnerResponse> convert(List<Owner> owners) {
    return owners.stream().map(this::convert).collect(Collectors.toList());
  }
}
