package ru.sibdigital.difar.controller.classier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsUnitRatioEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsUnitRatioRepository;

import java.util.Optional;

@RestController
@RequestMapping("/unit-ratio")
public class ClsUnitRatioController {

    private ClsUnitRatioRepository repository;

    public ClsUnitRatioController(ClsUnitRatioRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsUnitRatioEntity create(@RequestBody ClsUnitRatioEntity entity) {
        ClsUnitRatioEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsUnitRatioEntity read(@PathVariable long id) {
        Optional<ClsUnitRatioEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/{id}")
    public ClsUnitRatioEntity update(@PathVariable long id, @RequestBody ClsUnitRatioEntity entityToUpdate) {
        ClsUnitRatioEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsUnitRatioEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
