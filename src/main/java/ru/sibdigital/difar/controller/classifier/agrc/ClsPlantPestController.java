package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsPlantPestEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsPlantPestRepository;

import java.util.Optional;

@RestController
@RequestMapping("/plant-pest")
public class ClsPlantPestController {

    private ClsPlantPestRepository repository;

    public ClsPlantPestController(ClsPlantPestRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsPlantPestEntity create(@RequestBody ClsPlantPestEntity entity) {
        ClsPlantPestEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsPlantPestEntity read(@PathVariable long id) {
        Optional<ClsPlantPestEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsPlantPestEntity update(@RequestBody ClsPlantPestEntity entityToUpdate) {
        ClsPlantPestEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsPlantPestEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
