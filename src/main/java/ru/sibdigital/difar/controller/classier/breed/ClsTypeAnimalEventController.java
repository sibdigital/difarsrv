package ru.sibdigital.difar.controller.classier.breed;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.breed.ClsTypeAnimalEventEntity;
import ru.sibdigital.difar.repository.classifier.breed.ClsTypeAnimalEventRepository;

import java.util.Optional;

@RestController
@RequestMapping("/type-animal-event")
public class ClsTypeAnimalEventController {

    private ClsTypeAnimalEventRepository repository;

    public ClsTypeAnimalEventController(ClsTypeAnimalEventRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsTypeAnimalEventEntity create(@RequestBody ClsTypeAnimalEventEntity entity) {
        ClsTypeAnimalEventEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsTypeAnimalEventEntity read(@PathVariable long id) {
        Optional<ClsTypeAnimalEventEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/{id}")
    public ClsTypeAnimalEventEntity update(@PathVariable long id, @RequestBody ClsTypeAnimalEventEntity entityToUpdate) {
        ClsTypeAnimalEventEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsTypeAnimalEventEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
