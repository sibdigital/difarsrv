package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsEquipmentTypeEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsEquipmentTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/equipment-type")
public class ClsEquipmentTypeController {

    private ClsEquipmentTypeRepository repository;

    public ClsEquipmentTypeController(ClsEquipmentTypeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsEquipmentTypeEntity create(@RequestBody ClsEquipmentTypeEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsEquipmentTypeEntity read(@PathVariable long id) {
        Optional<ClsEquipmentTypeEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsEquipmentTypeEntity update(@RequestBody ClsEquipmentTypeEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsEquipmentTypeEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsEquipmentTypeEntity> findAll() {
        List<ClsEquipmentTypeEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
