package sha2ya3n.the2gen3tel4man.petclinic.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sha2ya3n.the2gen3tel4man.petclinic.services.SpecialityService;
import sha2ya3n.the2gen3tel4man.petclinic.model.Specialty;
import sha2ya3n.the2gen3tel4man.petclinic.repository.SpecialityRepository;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Specialty findById(Long aLong) {
        Optional<Specialty> specialtyOptional = specialityRepository.findById(aLong);
        if(specialtyOptional.isPresent()){
            return specialtyOptional.get();
        }else{
            return null;
        }
    }

    @Override
    public Specialty save(Specialty object) {
        return specialityRepository.save(object);
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialityRepository.findAll().iterator().forEachRemaining(specialties::add);
        return specialties;
    }

    @Override
    public void delete(Specialty object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepository.deleteById(aLong);
    }
}
