package ru.sibdigital.difar.controller.classier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsWorkTypeEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsWorkTypeRepository;

import java.util.Optional;

@RestController
@RequestMapping("/work-type")
public class ClsWorkTypeController {

    private ClsWorkTypeRepository repository;

    public ClsWorkTypeController(ClsWorkTypeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsWorkTypeEntity create(@RequestBody ClsWorkTypeEntity entity) {
        ClsWorkTypeEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsWorkTypeEntity read(@PathVariable long id) {
        Optional<ClsWorkTypeEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/{id}")
    public ClsWorkTypeEntity update(@PathVariable long id, @RequestBody ClsWorkTypeEntity entityToUpdate) {
        ClsWorkTypeEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsWorkTypeEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
