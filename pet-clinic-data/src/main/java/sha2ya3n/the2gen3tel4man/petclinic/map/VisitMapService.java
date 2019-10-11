package sha2ya3n.the2gen3tel4man.petclinic.map;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sha2ya3n.the2gen3tel4man.petclinic.model.Visit;
import sha2ya3n.the2gen3tel4man.petclinic.services.VisitService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null || visit.getPet().getId() == null || visit.getPet().getOwner() == null
        || visit.getPet().getOwner().getId() == null){
            throw new RuntimeException("RuntimException in VisiMapService in save method");
        }
        return super.save(visit);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit object) {
        super.deleteByObject(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
