package ru.sibdigital.difar.controller.classier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsDiseaseFeatureEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsDiseaseFeatureRepository;

import java.util.Optional;

@RestController
@RequestMapping("/disease-feature")
public class ClsDiseaseFeatureController {

    private ClsDiseaseFeatureRepository repository;

    public ClsDiseaseFeatureController(ClsDiseaseFeatureRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsDiseaseFeatureEntity create(@RequestBody ClsDiseaseFeatureEntity entity) {
        ClsDiseaseFeatureEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsDiseaseFeatureEntity read(@PathVariable long id) {
        Optional<ClsDiseaseFeatureEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/{id}")
    public ClsDiseaseFeatureEntity update(@PathVariable long id, @RequestBody ClsDiseaseFeatureEntity entityToUpdate) {
        ClsDiseaseFeatureEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsDiseaseFeatureEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
