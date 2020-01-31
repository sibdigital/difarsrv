package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsConsumableEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsConsumableRepository;

import java.util.Optional;

@RestController
@RequestMapping("/consumable")
public class ClsConsumableController {

    private ClsConsumableRepository repository;

    public ClsConsumableController(ClsConsumableRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsConsumableEntity create(@RequestBody ClsConsumableEntity entity) {
        ClsConsumableEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsConsumableEntity read(@PathVariable long id) {
        Optional<ClsConsumableEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsConsumableEntity update(@RequestBody ClsConsumableEntity entityToUpdate) {
        ClsConsumableEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsConsumableEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
