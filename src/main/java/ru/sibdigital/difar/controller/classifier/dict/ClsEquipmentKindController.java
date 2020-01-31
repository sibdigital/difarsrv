package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsEquipmentKindEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsEquipmentKindRepository;

import java.util.Optional;

@RestController
@RequestMapping("/equipment-kind")
public class ClsEquipmentKindController {

    private ClsEquipmentKindRepository repository;

    public ClsEquipmentKindController(ClsEquipmentKindRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsEquipmentKindEntity create(@RequestBody ClsEquipmentKindEntity entity) {
        ClsEquipmentKindEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsEquipmentKindEntity read(@PathVariable long id) {
        Optional<ClsEquipmentKindEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsEquipmentKindEntity update(@RequestBody ClsEquipmentKindEntity entityToUpdate) {
        ClsEquipmentKindEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsEquipmentKindEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
