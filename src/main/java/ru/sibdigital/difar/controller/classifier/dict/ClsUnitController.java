package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsUnitEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsUnitRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/unit")
public class ClsUnitController {

    private ClsUnitRepository repository;

    public ClsUnitController(ClsUnitRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsUnitEntity create(@RequestBody ClsUnitEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsUnitEntity read(@PathVariable long id) {
        Optional<ClsUnitEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsUnitEntity update(@RequestBody ClsUnitEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsUnitEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsUnitEntity> findAll() {
        List<ClsUnitEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }
}
