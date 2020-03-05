package ru.sibdigital.difar.controller.classifier.org;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.org.ClsPositionEntity;
import ru.sibdigital.difar.repository.classifier.org.ClsPositionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/position")
public class ClsPositionController {

    private ClsPositionRepository repository;

    public ClsPositionController(ClsPositionRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsPositionEntity create(@RequestBody ClsPositionEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsPositionEntity read(@PathVariable long id) {
        Optional<ClsPositionEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsPositionEntity update(@RequestBody ClsPositionEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsPositionEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsPositionEntity> findAll() {
        List<ClsPositionEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
