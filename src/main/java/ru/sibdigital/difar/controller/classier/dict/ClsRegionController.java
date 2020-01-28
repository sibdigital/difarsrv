package ru.sibdigital.difar.controller.classier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsRegionEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsRegionRepository;

import java.util.Optional;

@RestController
@RequestMapping("/region")
public class ClsRegionController {

    private ClsRegionRepository repository;

    public ClsRegionController(ClsRegionRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsRegionEntity create(@RequestBody ClsRegionEntity entity) {
        ClsRegionEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsRegionEntity read(@PathVariable long id) {
        Optional<ClsRegionEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/{id}")
    public ClsRegionEntity update(@PathVariable long id, @RequestBody ClsRegionEntity entityToUpdate) {
        ClsRegionEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsRegionEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
