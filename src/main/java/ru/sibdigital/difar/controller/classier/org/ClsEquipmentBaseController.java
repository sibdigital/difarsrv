package ru.sibdigital.difar.controller.classier.org;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.org.ClsEquipmentBaseEntity;
import ru.sibdigital.difar.repository.classifier.org.ClsEquipmentBaseRepository;

import java.util.Optional;

@RestController
@RequestMapping("/equipment-base")
public class ClsEquipmentBaseController {

    private ClsEquipmentBaseRepository repository;

    public ClsEquipmentBaseController(ClsEquipmentBaseRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsEquipmentBaseEntity create(@RequestBody ClsEquipmentBaseEntity entity) {
        ClsEquipmentBaseEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsEquipmentBaseEntity read(@PathVariable long id) {
        Optional<ClsEquipmentBaseEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/{id}")
    public ClsEquipmentBaseEntity update(@PathVariable long id, @RequestBody ClsEquipmentBaseEntity entityToUpdate) {
        ClsEquipmentBaseEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsEquipmentBaseEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
