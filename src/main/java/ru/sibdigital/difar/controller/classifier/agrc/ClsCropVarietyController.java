package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsCropVarietyEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsCropVarietyRepository;

import java.util.Optional;

@RestController
@RequestMapping("/crop-variety")
public class ClsCropVarietyController {

    private ClsCropVarietyRepository repository;

    public ClsCropVarietyController(ClsCropVarietyRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsCropVarietyEntity create(@RequestBody ClsCropVarietyEntity entity) {
        ClsCropVarietyEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsCropVarietyEntity read(@PathVariable long id) {
        Optional<ClsCropVarietyEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsCropVarietyEntity update(@RequestBody ClsCropVarietyEntity entityToUpdate) {
        ClsCropVarietyEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsCropVarietyEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
