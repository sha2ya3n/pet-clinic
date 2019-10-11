package sha2ya3n.the2gen3tel4man.petclinic.map;

import org.junit.Before;
import org.junit.Test;
import sha2ya3n.the2gen3tel4man.petclinic.model.Owner;
import sha2ya3n.the2gen3tel4man.petclinic.model.Pet;

import java.util.Set;

import static org.junit.Assert.*;

public class PetMapServiceTest {

    PetMapService petMapService;

    final Long idValue = 1L;
    final String name = "Jepcy";

    @Before
    public void setUp() throws Exception{
       petMapService = new PetMapService();
       Pet pet = new Pet();
       pet.setId(idValue);
       pet.setName(name);
       petMapService.save(pet);

    }

    @Test
    public void findById() {
        Pet pet = petMapService.findById(idValue);
        assertEquals(idValue, pet.getId());
    }

    @Test
    public void save() {
        Pet newPet = new Pet();
        newPet.setId(idValue);
        Pet petnewOne = petMapService.save(newPet);

        assertEquals(idValue,petnewOne.getId());
    }

    @Test
    public void findAll() {
        Set<Pet> petSet = petMapService.findAll();
        assertEquals(1, petSet.size());
    }

    @Test
    public void delete() {
        petMapService.deleteByObject(petMapService.findById(idValue));

        assertEquals(0, petMapService.findAll().size());

    }

    @Test
    public void deleteById() {
        petMapService.delete(petMapService.findById(idValue));

        assertEquals(0, petMapService.findAll().size());
    }
}