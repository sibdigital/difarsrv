package ru.sibdigital.difar.controller.classifier.breed;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.breed.ClsAnimalRetirementCauseEntity;
import ru.sibdigital.difar.repository.classifier.breed.ClsAnimalRetirementCauseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animal-retirement-cause")
public class ClsAnimalRetirementCauseController {

    private ClsAnimalRetirementCauseRepository repository;

    public ClsAnimalRetirementCauseController(ClsAnimalRetirementCauseRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsAnimalRetirementCauseEntity create(@RequestBody ClsAnimalRetirementCauseEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsAnimalRetirementCauseEntity read(@PathVariable long id) {
        Optional<ClsAnimalRetirementCauseEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsAnimalRetirementCauseEntity update(@RequestBody ClsAnimalRetirementCauseEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsAnimalRetirementCauseEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsAnimalRetirementCauseEntity> findAll() {
        List<ClsAnimalRetirementCauseEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
