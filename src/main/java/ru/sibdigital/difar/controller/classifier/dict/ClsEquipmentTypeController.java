package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsEquipmentTypeEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsEquipmentTypeRepository;

import java.util.Optional;

@RestController
@RequestMapping("/equipment-type")
public class ClsEquipmentTypeController {

    private ClsEquipmentTypeRepository repository;

    public ClsEquipmentTypeController(ClsEquipmentTypeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsEquipmentTypeEntity create(@RequestBody ClsEquipmentTypeEntity entity) {
        ClsEquipmentTypeEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsEquipmentTypeEntity read(@PathVariable long id) {
        Optional<ClsEquipmentTypeEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsEquipmentTypeEntity update(@RequestBody ClsEquipmentTypeEntity entityToUpdate) {
        ClsEquipmentTypeEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsEquipmentTypeEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
