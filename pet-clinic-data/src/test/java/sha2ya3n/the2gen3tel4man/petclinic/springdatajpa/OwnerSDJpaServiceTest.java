package sha2ya3n.the2gen3tel4man.petclinic.springdatajpa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import sha2ya3n.the2gen3tel4man.petclinic.model.Owner;
import sha2ya3n.the2gen3tel4man.petclinic.repository.OwnerRepository;
import sha2ya3n.the2gen3tel4man.petclinic.repository.PetRepository;
import sha2ya3n.the2gen3tel4man.petclinic.repository.PetTypeRepository;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    OwnerSDJpaService service;

    final Long idValue = 1L;
    final String lastName = "Smith";

    @Before
    public void setUp() throws Exception {
        service = new OwnerSDJpaService(ownerRepository, petRepository, petTypeRepository);
        Owner owner = new Owner();
        owner.setId(idValue);
        owner.setLastName(lastName);
//        service.save(owner);

    }

    @Test
    public void findByLastName() {
        Owner returnOwner = new Owner();
        returnOwner.setId(idValue);
        returnOwner.setLastName(lastName);

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner owner = service.findByLastName(lastName);

        assertEquals(lastName, owner.getLastName());

        verify(ownerRepository.findByLastName(any()));
    }

    @Test
    public void findById() {
    }

    @Test
    public void save() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void deleteById() {
    }
}