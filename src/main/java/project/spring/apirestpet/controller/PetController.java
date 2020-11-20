package project.spring.apirestpet.controller;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.*;import project.spring.apirestpet.entity.Pet;import project.spring.apirestpet.service.PetService;import java.util.List;@RestController@RequestMapping("/api/pet")public class PetController {    @Autowired    private PetService petService;    @GetMapping    public List<Pet> findAll() {        return petService.findAll();    }    @GetMapping("/{id}")    public Pet findById(@PathVariable Long id) {        return petService.findById(id);    }    @PostMapping    public Pet save(@RequestBody Pet pet) {        return petService.save(pet);    }    @PutMapping("/{id}")    public Pet update(@PathVariable Long id, @RequestBody Pet pet) {        return petService.update(id, pet);    }    @DeleteMapping("/{id}")    public void delete(@PathVariable Long id) {        petService.delete(id);    }}