package ru.sibdigital.difar.controller.classifier.breed;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.breed.ClsAnimalParamKindEntity;
import ru.sibdigital.difar.repository.classifier.breed.ClsAnimalParamKindRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animal-param-kind")
public class ClsAnimalParamKindController {

    private ClsAnimalParamKindRepository repository;

    public ClsAnimalParamKindController(ClsAnimalParamKindRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsAnimalParamKindEntity create(@RequestBody ClsAnimalParamKindEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsAnimalParamKindEntity read(@PathVariable long id) {
        Optional<ClsAnimalParamKindEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsAnimalParamKindEntity update(@RequestBody ClsAnimalParamKindEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsAnimalParamKindEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsAnimalParamKindEntity> findAll() {
        List<ClsAnimalParamKindEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }
}
