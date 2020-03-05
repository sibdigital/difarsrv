package ru.sibdigital.difar.controller.classifier.breed;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.breed.ClsAnimalGroupKindEntity;
import ru.sibdigital.difar.repository.classifier.breed.ClsAnimalGroupKindRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animal-group-kind")
public class ClsAnimalGroupKindController {

    private ClsAnimalGroupKindRepository repository;

    public ClsAnimalGroupKindController(ClsAnimalGroupKindRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsAnimalGroupKindEntity create(@RequestBody ClsAnimalGroupKindEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsAnimalGroupKindEntity read(@PathVariable long id) {
        Optional<ClsAnimalGroupKindEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsAnimalGroupKindEntity update(@RequestBody ClsAnimalGroupKindEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsAnimalGroupKindEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsAnimalGroupKindEntity> findAll() {
        List<ClsAnimalGroupKindEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }
}
