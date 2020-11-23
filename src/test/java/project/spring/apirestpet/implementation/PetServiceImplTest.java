package project.spring.apirestpet.implementation;import org.junit.jupiter.api.Test;import org.mockito.InjectMocks;import org.mockito.Mock;import org.mockito.Mockito;import org.springframework.boot.test.context.SpringBootTest;import project.spring.apirestpet.entity.Pet;import project.spring.apirestpet.repository.PetRepository;import java.util.ArrayList;import java.util.List;import java.util.Optional;import static org.junit.jupiter.api.Assertions.*;@SpringBootTestclass PetServiceImplTest {    @InjectMocks    private PetServiceImpl petService;    @Mock    private PetRepository petRepository;    @Test    void find_all_pets() {        List<Pet> pets=new ArrayList<>();        pets.add(new Pet(1L,"lu",2,"cat","persa"));        pets.add(new Pet(2L,"lu",2,"cat","persa"));        pets.add(new Pet(3L,"lu",2,"cat","persa"));        Mockito.when(petRepository.findAll()).thenReturn(pets);        List<Pet> data=petService.findAll();        assertEquals(3,data.size());        assertFalse(data.isEmpty());        assertNotNull(data);    }    @Test    void find_by_id_pet() {        Pet pet= Pet.builder().id(1L).name("lu").age(10).species("cat").breed("persa").build();        Mockito.when(petRepository.findById(pet.getId())).thenReturn(Optional.of(pet));        long id=1L;        Pet data=petService.findById(id);        assertEquals(id,data.getId());        assertNotNull(data);    }    @Test    void save_pet() {        Pet pet= Pet.builder().id(1L).name("lu").age(10).species("cat").breed("persa").build();        Mockito.when(petRepository.save(pet)).thenReturn(pet);        Pet data=petService.save(pet);        assertNotNull(data);        assertEquals(data,petService.save(pet));    }    @Test    void update_pet() {        long id=1L;        Pet pet= Pet.builder().id(1L).name("lu").age(10).species("cat").breed("persa").build();        Mockito.when(petRepository.save(pet)).thenReturn(pet);        pet.setName("jul");        Pet data=petService.update(id,pet);        assertEquals(data.getName(),pet.getName());        assertNotNull(data);    }    @Test    void delete() {        Pet pet= Pet.builder().id(1L).name("lu").age(10).species("cat").breed("persa").build();        petRepository.deleteById(pet.getId());        long id=1L;        petService.delete(id);        Pet data=petService.findById(id);        assertNotEquals(data,pet);        assertNull(data);    }}