package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsRegionEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsRegionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/region")
public class ClsRegionController {

    private ClsRegionRepository repository;

    public ClsRegionController(ClsRegionRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsRegionEntity create(@RequestBody ClsRegionEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsRegionEntity read(@PathVariable long id) {
        Optional<ClsRegionEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsRegionEntity update(@RequestBody ClsRegionEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsRegionEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsRegionEntity> findAll() {
        List<ClsRegionEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
