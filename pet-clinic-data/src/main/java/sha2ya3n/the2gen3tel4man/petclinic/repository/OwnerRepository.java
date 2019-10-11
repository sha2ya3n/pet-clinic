package sha2ya3n.the2gen3tel4man.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import sha2ya3n.the2gen3tel4man.petclinic.model.Owner;

import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

}
