package ru.sibdigital.difar.controller.classifier.breed;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.breed.ClsBreedEntity;
import ru.sibdigital.difar.repository.classifier.breed.ClsBreedRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/breed")
public class ClsBreedController {

    private ClsBreedRepository repository;

    public ClsBreedController(ClsBreedRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsBreedEntity create(@RequestBody ClsBreedEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsBreedEntity read(@PathVariable long id) {
        Optional<ClsBreedEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsBreedEntity update(@RequestBody ClsBreedEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsBreedEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsBreedEntity> findAll() {
        List<ClsBreedEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
