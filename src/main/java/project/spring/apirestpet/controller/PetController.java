package project.spring.apirestpet.controller;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.*;import project.spring.apirestpet.model.dto.PetDto;import project.spring.apirestpet.service.PetService;import java.util.List;@RestController@RequestMapping("/api/pets")public class PetController {    @Autowired    private PetService petService;    @GetMapping    public List<PetDto> findAll() {        return petService.findAll();    }    @GetMapping("/{id}")    public PetDto findById(@PathVariable Long id) {        return petService.findById(id);    }    @PostMapping    public PetDto save(@RequestBody PetDto pet) {        return petService.save(pet);    }    @PutMapping("/{id}")    public PetDto update(@PathVariable Long id, @RequestBody PetDto pet) {        return petService.update(id, pet);    }    @DeleteMapping("/{id}")    public void delete(@PathVariable Long id) {        petService.delete(id);    }}