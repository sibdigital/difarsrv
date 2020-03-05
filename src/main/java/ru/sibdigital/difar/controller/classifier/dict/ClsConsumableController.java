package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsConsumableEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsConsumableRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consumable")
public class ClsConsumableController {

    private ClsConsumableRepository repository;

    public ClsConsumableController(ClsConsumableRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsConsumableEntity create(@RequestBody ClsConsumableEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsConsumableEntity read(@PathVariable long id) {
        Optional<ClsConsumableEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsConsumableEntity update(@RequestBody ClsConsumableEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsConsumableEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsConsumableEntity> findAll() {
        List<ClsConsumableEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
