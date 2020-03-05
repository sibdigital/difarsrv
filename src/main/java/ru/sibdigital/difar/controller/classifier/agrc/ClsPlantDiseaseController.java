package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsPlantDiseaseEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsPlantDiseaseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plant-disease")
public class ClsPlantDiseaseController {

    private ClsPlantDiseaseRepository repository;

    public ClsPlantDiseaseController(ClsPlantDiseaseRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsPlantDiseaseEntity create(@RequestBody ClsPlantDiseaseEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsPlantDiseaseEntity read(@PathVariable long id) {
        Optional<ClsPlantDiseaseEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsPlantDiseaseEntity update(@RequestBody ClsPlantDiseaseEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsPlantDiseaseEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsPlantDiseaseEntity> findAll() {
        List<ClsPlantDiseaseEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }
}
