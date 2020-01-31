package ru.sibdigital.difar.controller.classifier.breed;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.breed.ClsAnimalGroupKindEntity;
import ru.sibdigital.difar.repository.classifier.breed.ClsAnimalGroupKindRepository;

import java.util.Optional;

@RestController
@RequestMapping("/animal-group-kind")
public class ClsAnimalGroupKindController {

    private ClsAnimalGroupKindRepository repository;

    public ClsAnimalGroupKindController(ClsAnimalGroupKindRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsAnimalGroupKindEntity create(@RequestBody ClsAnimalGroupKindEntity entity) {
        ClsAnimalGroupKindEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsAnimalGroupKindEntity read(@PathVariable long id) {
        Optional<ClsAnimalGroupKindEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsAnimalGroupKindEntity update(@RequestBody ClsAnimalGroupKindEntity entityToUpdate) {
        ClsAnimalGroupKindEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsAnimalGroupKindEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
