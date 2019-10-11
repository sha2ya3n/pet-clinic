package sha2ya3n.the2gen3tel4man.petclinic.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sha2ya3n.the2gen3tel4man.petclinic.model.Specialty;
import sha2ya3n.the2gen3tel4man.petclinic.services.SpecialityService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class SpecialityMapService extends AbstractMapService<Specialty, Long> implements SpecialityService {


    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Specialty object) {
        super.deleteByObject(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
