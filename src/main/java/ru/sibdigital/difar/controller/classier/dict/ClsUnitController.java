package ru.sibdigital.difar.controller.classier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsUnitEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsUnitRepository;

import java.util.Optional;

@RestController
@RequestMapping("/unit")
public class ClsUnitController {

    private ClsUnitRepository repository;

    public ClsUnitController(ClsUnitRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsUnitEntity create(@RequestBody ClsUnitEntity entity) {
        ClsUnitEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsUnitEntity read(@PathVariable long id) {
        Optional<ClsUnitEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/{id}")
    public ClsUnitEntity update(@PathVariable long id, @RequestBody ClsUnitEntity entityToUpdate) {
        ClsUnitEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsUnitEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
