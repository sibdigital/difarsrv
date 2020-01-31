package ru.sibdigital.difar.controller.classifier.breed;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.breed.ClsBreedEntity;
import ru.sibdigital.difar.repository.classifier.breed.ClsBreedRepository;

import java.util.Optional;

@RestController
@RequestMapping("/breed")
public class ClsBreedController {

    private ClsBreedRepository repository;

    public ClsBreedController(ClsBreedRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsBreedEntity create(@RequestBody ClsBreedEntity entity) {
        ClsBreedEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsBreedEntity read(@PathVariable long id) {
        Optional<ClsBreedEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsBreedEntity update(@RequestBody ClsBreedEntity entityToUpdate) {
        ClsBreedEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsBreedEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
