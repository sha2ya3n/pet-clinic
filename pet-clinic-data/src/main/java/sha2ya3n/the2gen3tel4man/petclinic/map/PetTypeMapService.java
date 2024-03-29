package sha2ya3n.the2gen3tel4man.petclinic.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sha2ya3n.the2gen3tel4man.petclinic.model.PetType;
import sha2ya3n.the2gen3tel4man.petclinic.services.PetTypeService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(PetType object) {
        super.deleteByObject(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
