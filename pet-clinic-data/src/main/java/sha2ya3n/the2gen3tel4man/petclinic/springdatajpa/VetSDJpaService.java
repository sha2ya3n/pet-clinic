package sha2ya3n.the2gen3tel4man.petclinic.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sha2ya3n.the2gen3tel4man.petclinic.services.VetService;
import sha2ya3n.the2gen3tel4man.petclinic.model.Vet;
import sha2ya3n.the2gen3tel4man.petclinic.repository.PetRepository;
import sha2ya3n.the2gen3tel4man.petclinic.repository.PetTypeRepository;
import sha2ya3n.the2gen3tel4man.petclinic.repository.SpecialityRepository;
import sha2ya3n.the2gen3tel4man.petclinic.repository.VetRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;
    private final SpecialityRepository specialityRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public VetSDJpaService(VetRepository vetRepository, SpecialityRepository specialityRepository,
                           PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.vetRepository = vetRepository;
        this.specialityRepository = specialityRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Vet findById(Long aLong) {
        Optional<Vet> vetOptional = vetRepository.findById(aLong);
        if(vetOptional.isPresent()){
            return vetOptional.get();
        }else{
            return null;
        }
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().iterator().forEachRemaining(vets::add);
        return vets;
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
