package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsPlantOrganEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsPlantOrganRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plant-organ")
public class ClsPlantOrganController {

    private ClsPlantOrganRepository repository;

    public ClsPlantOrganController(ClsPlantOrganRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsPlantOrganEntity create(@RequestBody ClsPlantOrganEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsPlantOrganEntity read(@PathVariable long id) {
        Optional<ClsPlantOrganEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsPlantOrganEntity update(@RequestBody ClsPlantOrganEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsPlantOrganEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsPlantOrganEntity> findAll() {
        List<ClsPlantOrganEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
