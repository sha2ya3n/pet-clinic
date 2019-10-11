package sha2ya3n.the2gen3tel4man.petclinic.services;

import sha2ya3n.the2gen3tel4man.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

//    Owner findById(Long id);
//
//    Set<Owner> findAll();
//
//    Owner save(Owner owner);
}
