package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsCropVarietyEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsCropVarietyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/crop-variety")
public class ClsCropVarietyController {

    private ClsCropVarietyRepository repository;

    public ClsCropVarietyController(ClsCropVarietyRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsCropVarietyEntity create(@RequestBody ClsCropVarietyEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsCropVarietyEntity read(@PathVariable long id) {
        Optional<ClsCropVarietyEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsCropVarietyEntity update(@RequestBody ClsCropVarietyEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsCropVarietyEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsCropVarietyEntity> findAll() {
        List<ClsCropVarietyEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
