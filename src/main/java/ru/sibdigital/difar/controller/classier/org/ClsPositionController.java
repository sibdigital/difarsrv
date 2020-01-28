package ru.sibdigital.difar.controller.classier.org;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.org.ClsPositionEntity;
import ru.sibdigital.difar.repository.classifier.org.ClsPositionRepository;

import java.util.Optional;

@RestController
@RequestMapping("/position")
public class ClsPositionController {

    private ClsPositionRepository repository;

    public ClsPositionController(ClsPositionRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsPositionEntity create(@RequestBody ClsPositionEntity entity) {
        ClsPositionEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsPositionEntity read(@PathVariable long id) {
        Optional<ClsPositionEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/{id}")
    public ClsPositionEntity update(@PathVariable long id, @RequestBody ClsPositionEntity entityToUpdate) {
        ClsPositionEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsPositionEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
