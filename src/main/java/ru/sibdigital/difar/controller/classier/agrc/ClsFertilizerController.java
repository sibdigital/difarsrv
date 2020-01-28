package ru.sibdigital.difar.controller.classier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsFertilizerEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsFertilizerRepository;

import java.util.Optional;

@RestController
@RequestMapping("/fertilizer")
public class ClsFertilizerController {

    private ClsFertilizerRepository repository;

    public ClsFertilizerController(ClsFertilizerRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsFertilizerEntity create(@RequestBody ClsFertilizerEntity entity) {
        ClsFertilizerEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsFertilizerEntity read(@PathVariable long id) {
        Optional<ClsFertilizerEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/{id}")
    public ClsFertilizerEntity update(@PathVariable long id, @RequestBody ClsFertilizerEntity entityToUpdate) {
        ClsFertilizerEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsFertilizerEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
