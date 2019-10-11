package sha2ya3n.the2gen3tel4man.petclinic.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sha2ya3n.the2gen3tel4man.petclinic.model.Specialty;
import sha2ya3n.the2gen3tel4man.petclinic.model.Vet;
import sha2ya3n.the2gen3tel4man.petclinic.services.SpecialityService;
import sha2ya3n.the2gen3tel4man.petclinic.services.VetService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialties().size() > 0){
            object.getSpecialties().forEach(specialty -> {
                if(specialty.getId() == null){
                    Specialty savedSpeciality = specialityService.save(specialty);
                    specialty.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.deleteByObject(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    //    @Override
//    public void delete(Vet object) {
//
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//
//    }
//
//    @Override
//    public Vet findById(Long id) {
//        return super.findById(id);
//    }
//
//    @Override
//    public Vet save(Vet object) {
//        return super.save(object.getId(), object);
//    }
//
//    @Override
//    public Set<Vet> findAll() {
//        return super.findAll();
//    }
//
//    @Override
//    void removeByObject(Vet object) {
//        super.removeByObject(object);
//    }
//
//    @Override
//    void removeById(Long aLong) {
//        super.removeById(aLong);
//    }
}
