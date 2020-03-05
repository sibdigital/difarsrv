package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsFertilizerEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsFertilizerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/fertilizer")
public class ClsFertilizerController {

    private ClsFertilizerRepository repository;

    public ClsFertilizerController(ClsFertilizerRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsFertilizerEntity create(@RequestBody ClsFertilizerEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsFertilizerEntity read(@PathVariable long id) {
        Optional<ClsFertilizerEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsFertilizerEntity update(@RequestBody ClsFertilizerEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsFertilizerEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsFertilizerEntity> findAll() {
        List<ClsFertilizerEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }
}
