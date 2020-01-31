package ru.sibdigital.difar.controller.classifier.breed;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.breed.ClsKindAnimalEntity;
import ru.sibdigital.difar.repository.classifier.breed.ClsKindAnimalRepository;

import java.util.Optional;

@RestController
@RequestMapping("/kind-animal")
public class ClsKindAnimalController {

    private ClsKindAnimalRepository repository;

    public ClsKindAnimalController(ClsKindAnimalRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsKindAnimalEntity create(@RequestBody ClsKindAnimalEntity entity) {
        ClsKindAnimalEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsKindAnimalEntity read(@PathVariable long id) {
        Optional<ClsKindAnimalEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsKindAnimalEntity update(@RequestBody ClsKindAnimalEntity entityToUpdate) {
        ClsKindAnimalEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsKindAnimalEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
