package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsCropEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsCropRepository;

import java.util.Optional;

@RestController
@RequestMapping("/crop")
public class ClsCropController {

    private ClsCropRepository repository;

    public ClsCropController(ClsCropRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsCropEntity create(@RequestBody ClsCropEntity entity) {
        ClsCropEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsCropEntity read(@PathVariable long id) {
        Optional<ClsCropEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsCropEntity update(@RequestBody ClsCropEntity entityToUpdate) {
        ClsCropEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsCropEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsCropEntity> get() {
        return repository.findAll();
    }

}
