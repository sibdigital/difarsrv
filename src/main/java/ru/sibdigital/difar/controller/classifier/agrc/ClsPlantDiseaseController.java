package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsPlantDiseaseEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsPlantDiseaseRepository;

import java.util.Optional;

@RestController
@RequestMapping("/plant-disease")
public class ClsPlantDiseaseController {

    private ClsPlantDiseaseRepository repository;

    public ClsPlantDiseaseController(ClsPlantDiseaseRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsPlantDiseaseEntity create(@RequestBody ClsPlantDiseaseEntity entity) {
        ClsPlantDiseaseEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsPlantDiseaseEntity read(@PathVariable long id) {
        Optional<ClsPlantDiseaseEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsPlantDiseaseEntity update(@RequestBody ClsPlantDiseaseEntity entityToUpdate) {
        ClsPlantDiseaseEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsPlantDiseaseEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
