package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsDiseaseFeatureEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsDiseaseFeatureRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/disease-feature")
public class ClsDiseaseFeatureController {

    private ClsDiseaseFeatureRepository repository;

    public ClsDiseaseFeatureController(ClsDiseaseFeatureRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsDiseaseFeatureEntity create(@RequestBody ClsDiseaseFeatureEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsDiseaseFeatureEntity read(@PathVariable long id) {
        Optional<ClsDiseaseFeatureEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsDiseaseFeatureEntity update(@RequestBody ClsDiseaseFeatureEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsDiseaseFeatureEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsDiseaseFeatureEntity> findAll() {
        List<ClsDiseaseFeatureEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
