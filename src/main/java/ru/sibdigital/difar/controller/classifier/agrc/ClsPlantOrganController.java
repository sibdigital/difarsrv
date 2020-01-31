package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsPlantOrganEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsPlantOrganRepository;

import java.util.Optional;

@RestController
@RequestMapping("/plant-organ")
public class ClsPlantOrganController {

    private ClsPlantOrganRepository repository;

    public ClsPlantOrganController(ClsPlantOrganRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsPlantOrganEntity create(@RequestBody ClsPlantOrganEntity entity) {
        ClsPlantOrganEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsPlantOrganEntity read(@PathVariable long id) {
        Optional<ClsPlantOrganEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsPlantOrganEntity update(@RequestBody ClsPlantOrganEntity entityToUpdate) {
        ClsPlantOrganEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsPlantOrganEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
