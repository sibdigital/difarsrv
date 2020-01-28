package ru.sibdigital.difar.controller.classier.breed;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.breed.ClsAnimalParamKindEntity;
import ru.sibdigital.difar.repository.classifier.breed.ClsAnimalParamKindRepository;

import java.util.Optional;

@RestController
@RequestMapping("/animal-param-kind")
public class ClsAnimalParamKindController {

    private ClsAnimalParamKindRepository repository;

    public ClsAnimalParamKindController(ClsAnimalParamKindRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsAnimalParamKindEntity create(@RequestBody ClsAnimalParamKindEntity entity) {
        ClsAnimalParamKindEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsAnimalParamKindEntity read(@PathVariable long id) {
        Optional<ClsAnimalParamKindEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/{id}")
    public ClsAnimalParamKindEntity update(@PathVariable long id, @RequestBody ClsAnimalParamKindEntity entityToUpdate) {
        ClsAnimalParamKindEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsAnimalParamKindEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
