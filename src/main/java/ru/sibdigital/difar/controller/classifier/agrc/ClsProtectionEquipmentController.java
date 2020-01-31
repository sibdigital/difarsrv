package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsProtectionEquipmentEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsProtectionEquipmentRepository;

import java.util.Optional;

@RestController
@RequestMapping("/protection-equipment")
public class ClsProtectionEquipmentController {

    private ClsProtectionEquipmentRepository repository;

    public ClsProtectionEquipmentController(ClsProtectionEquipmentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsProtectionEquipmentEntity create(@RequestBody ClsProtectionEquipmentEntity entity) {
        ClsProtectionEquipmentEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsProtectionEquipmentEntity read(@PathVariable long id) {
        Optional<ClsProtectionEquipmentEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsProtectionEquipmentEntity update(@RequestBody ClsProtectionEquipmentEntity entityToUpdate) {
        ClsProtectionEquipmentEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsProtectionEquipmentEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
