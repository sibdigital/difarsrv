package ru.sibdigital.difar.controller.classifier.breed;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.breed.ClsTypeAnimalEventEntity;
import ru.sibdigital.difar.repository.classifier.breed.ClsTypeAnimalEventRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/type-animal-event")
public class ClsTypeAnimalEventController {

    private ClsTypeAnimalEventRepository repository;

    public ClsTypeAnimalEventController(ClsTypeAnimalEventRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsTypeAnimalEventEntity create(@RequestBody ClsTypeAnimalEventEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsTypeAnimalEventEntity read(@PathVariable long id) {
        Optional<ClsTypeAnimalEventEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsTypeAnimalEventEntity update(@RequestBody ClsTypeAnimalEventEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsTypeAnimalEventEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsTypeAnimalEventEntity> findAll() {
        List<ClsTypeAnimalEventEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
