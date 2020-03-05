package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsAreaEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsAreaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/area")
public class ClsAreaController {

    private ClsAreaRepository repository;

    public ClsAreaController(ClsAreaRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsAreaEntity create(@RequestBody ClsAreaEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsAreaEntity read(@PathVariable long id) {
        Optional<ClsAreaEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsAreaEntity update(@RequestBody ClsAreaEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsAreaEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsAreaEntity> findAll() {
        List<ClsAreaEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
