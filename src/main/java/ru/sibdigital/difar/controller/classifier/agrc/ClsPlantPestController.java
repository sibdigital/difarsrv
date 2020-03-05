package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsPlantPestEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsPlantPestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plant-pest")
public class ClsPlantPestController {

    private ClsPlantPestRepository repository;

    public ClsPlantPestController(ClsPlantPestRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsPlantPestEntity create(@RequestBody ClsPlantPestEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsPlantPestEntity read(@PathVariable long id) {
        Optional<ClsPlantPestEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsPlantPestEntity update(@RequestBody ClsPlantPestEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsPlantPestEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsPlantPestEntity> findAll() {
        List<ClsPlantPestEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }
}
