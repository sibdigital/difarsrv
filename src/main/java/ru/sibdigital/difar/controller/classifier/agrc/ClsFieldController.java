package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsFieldEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsFieldRepository;

import java.util.Optional;

@RestController
@RequestMapping("/field")
public class ClsFieldController {

    private ClsFieldRepository repository;

    public ClsFieldController(ClsFieldRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsFieldEntity create(@RequestBody ClsFieldEntity entity) {
        ClsFieldEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsFieldEntity read(@PathVariable long id) {
        Optional<ClsFieldEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsFieldEntity update(@RequestBody ClsFieldEntity entityToUpdate) {
        ClsFieldEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsFieldEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
