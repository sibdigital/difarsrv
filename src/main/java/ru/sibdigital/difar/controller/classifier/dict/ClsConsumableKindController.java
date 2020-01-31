package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsConsumableKindEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsConsumableKindRepository;

import java.util.Optional;

@RestController
@RequestMapping("/consumable-kind")
public class ClsConsumableKindController {

    private ClsConsumableKindRepository repository;

    public ClsConsumableKindController(ClsConsumableKindRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsConsumableKindEntity create(@RequestBody ClsConsumableKindEntity entity) {
        ClsConsumableKindEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsConsumableKindEntity read(@PathVariable long id) {
        Optional<ClsConsumableKindEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsConsumableKindEntity update(@RequestBody ClsConsumableKindEntity entityToUpdate) {
        ClsConsumableKindEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsConsumableKindEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
