package sha2ya3n.the2gen3tel4man.petclinic.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sha2ya3n.the2gen3tel4man.petclinic.model.Owner;
import sha2ya3n.the2gen3tel4man.petclinic.services.OwnerService;
import sha2ya3n.the2gen3tel4man.petclinic.services.PetService;
import sha2ya3n.the2gen3tel4man.petclinic.services.PetTypeService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerMapService(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Owner save(Owner object) {
//        if(object != null){
//            if(object.getPets() != null){
//                for(Pet pet: object.getPets()){
//                    if(pet.getPetType() != null){
//                        if(pet.getPetType().getId() == null){
//                            pet.setPetType(petTypeService.save(pet.getPetType()));
//                        }
//                    }else{
//                        throw new RuntimeException("Type u were looking for is already requiered");
//                    }
//                    if(pet.getId() == null){
//                        Pet savedPet = petService.save(pet);
//                        pet.setId(savedPet.getId());
//                    }
//                }
//            }
//            return super.save(object);
//        }else{
//            return null;
//        }

        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("Type u were looking for is already requiered");
                    }
                    if(pet.getId() == null){
                        pet.setId(1L);
//                        Pet petSaved = petService.save(pet);
//                        pet.setId(petSaved.getId());
                    }
                });
            }
            return super.save(object);
        }else{
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.deleteByObject(object);
    }

}
