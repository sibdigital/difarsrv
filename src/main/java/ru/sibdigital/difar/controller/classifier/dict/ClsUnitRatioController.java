package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsUnitRatioEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsUnitRatioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/unit-ratio")
public class ClsUnitRatioController {

    private ClsUnitRatioRepository repository;

    public ClsUnitRatioController(ClsUnitRatioRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsUnitRatioEntity create(@RequestBody ClsUnitRatioEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsUnitRatioEntity read(@PathVariable long id) {
        Optional<ClsUnitRatioEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsUnitRatioEntity update(@RequestBody ClsUnitRatioEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsUnitRatioEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsUnitRatioEntity> findAll() {
        List<ClsUnitRatioEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
