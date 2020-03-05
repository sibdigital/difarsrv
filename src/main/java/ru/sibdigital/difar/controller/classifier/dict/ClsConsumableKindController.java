package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsConsumableKindEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsConsumableKindRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consumable-kind")
public class ClsConsumableKindController {

    private ClsConsumableKindRepository repository;

    public ClsConsumableKindController(ClsConsumableKindRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsConsumableKindEntity create(@RequestBody ClsConsumableKindEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsConsumableKindEntity read(@PathVariable long id) {
        Optional<ClsConsumableKindEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsConsumableKindEntity update(@RequestBody ClsConsumableKindEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsConsumableKindEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsConsumableKindEntity> findAll() {
        List<ClsConsumableKindEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
