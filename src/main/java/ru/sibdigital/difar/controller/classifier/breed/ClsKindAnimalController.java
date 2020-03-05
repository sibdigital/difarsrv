package ru.sibdigital.difar.controller.classifier.breed;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.breed.ClsKindAnimalEntity;
import ru.sibdigital.difar.repository.classifier.breed.ClsKindAnimalRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/kind-animal")
public class ClsKindAnimalController {

    private ClsKindAnimalRepository repository;

    public ClsKindAnimalController(ClsKindAnimalRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsKindAnimalEntity create(@RequestBody ClsKindAnimalEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsKindAnimalEntity read(@PathVariable long id) {
        Optional<ClsKindAnimalEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsKindAnimalEntity update(@RequestBody ClsKindAnimalEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsKindAnimalEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsKindAnimalEntity> findAll() {
        List<ClsKindAnimalEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
