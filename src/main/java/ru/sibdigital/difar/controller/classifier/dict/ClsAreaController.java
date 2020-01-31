package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsAreaEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsAreaRepository;

import java.util.Optional;

@RestController
@RequestMapping("/area")
public class ClsAreaController {

    private ClsAreaRepository repository;

    public ClsAreaController(ClsAreaRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsAreaEntity create(@RequestBody ClsAreaEntity entity) {
        ClsAreaEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsAreaEntity read(@PathVariable long id) {
        Optional<ClsAreaEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsAreaEntity update(@RequestBody ClsAreaEntity entityToUpdate) {
        ClsAreaEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsAreaEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
