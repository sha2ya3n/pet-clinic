package sha2ya3n.the2gen3tel4man.petclinic.map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sha2ya3n.the2gen3tel4man.petclinic.model.Owner;
import sha2ya3n.the2gen3tel4man.petclinic.services.PetService;
import sha2ya3n.the2gen3tel4man.petclinic.services.PetTypeService;

import javax.jws.Oneway;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    @Mock
    PetTypeService petTypeService;

    @Mock
    PetService petService;

    final Long id = 1L;
    final String lastName = "Smith";

    @Before
    public void setUp() throws Exception {
        ownerMapService = new OwnerMapService(petService, petTypeService);
        MockitoAnnotations.initMocks(this);

        Owner owner = new Owner();
        owner.setId(id);
        owner.setLastName(lastName);
        ownerMapService.save(owner);

    }

    @Test
    public void findById() {
        Owner owner = new Owner();
        owner.setId(id);

        Owner owner1 = ownerMapService.save(owner);

        assertEquals(id, owner1.getId());


    }

    @Test
    public void findAll() {
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
//        Set<Owner> owners = new HashSet<>();
//        owners.add(owner1);
//        owners.add(owner2);

        ownerMapService.save(owner1);
        ownerMapService.save(owner2);

        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(2, ownerSet.size());

    }

    @Test
    public void deleteById() {
        ownerMapService.delete(ownerMapService.findById(id));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    public void findByLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);
        assertNotNull(owner);

        assertEquals(id, owner.getId());
    }

    @Test
    public void save() {
    }

    @Test
    public void delete() {
    }
}