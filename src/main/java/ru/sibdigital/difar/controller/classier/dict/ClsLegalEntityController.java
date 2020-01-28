package ru.sibdigital.difar.controller.classier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsLegalEntityEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsLegalEntityRepository;

import java.util.Optional;

@RestController
@RequestMapping("/legal-entity")
public class ClsLegalEntityController {

    private ClsLegalEntityRepository repository;

    public ClsLegalEntityController(ClsLegalEntityRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsLegalEntityEntity create(@RequestBody ClsLegalEntityEntity entity) {
        ClsLegalEntityEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsLegalEntityEntity read(@PathVariable long id) {
        Optional<ClsLegalEntityEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/{id}")
    public ClsLegalEntityEntity update(@PathVariable long id, @RequestBody ClsLegalEntityEntity entityToUpdate) {
        ClsLegalEntityEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsLegalEntityEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
