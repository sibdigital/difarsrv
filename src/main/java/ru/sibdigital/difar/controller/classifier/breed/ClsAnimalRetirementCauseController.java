package ru.sibdigital.difar.controller.classifier.breed;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.breed.ClsAnimalRetirementCauseEntity;
import ru.sibdigital.difar.repository.classifier.breed.ClsAnimalRetirementCauseRepository;

import java.util.Optional;

@RestController
@RequestMapping("/animal-retirement-cause")
public class ClsAnimalRetirementCauseController {

    private ClsAnimalRetirementCauseRepository repository;

    public ClsAnimalRetirementCauseController(ClsAnimalRetirementCauseRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsAnimalRetirementCauseEntity create(@RequestBody ClsAnimalRetirementCauseEntity entity) {
        ClsAnimalRetirementCauseEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsAnimalRetirementCauseEntity read(@PathVariable long id) {
        Optional<ClsAnimalRetirementCauseEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsAnimalRetirementCauseEntity update(@RequestBody ClsAnimalRetirementCauseEntity entityToUpdate) {
        ClsAnimalRetirementCauseEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsAnimalRetirementCauseEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
