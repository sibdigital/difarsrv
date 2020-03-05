package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsWorkTypeEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsWorkTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/work-type")
public class ClsWorkTypeController {

    private ClsWorkTypeRepository repository;

    public ClsWorkTypeController(ClsWorkTypeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsWorkTypeEntity create(@RequestBody ClsWorkTypeEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsWorkTypeEntity read(@PathVariable long id) {
        Optional<ClsWorkTypeEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsWorkTypeEntity update(@RequestBody ClsWorkTypeEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsWorkTypeEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsWorkTypeEntity> findAll() {
        List<ClsWorkTypeEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
