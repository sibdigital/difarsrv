package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsProtectionEquipmentEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsProtectionEquipmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/protection-equipment")
public class ClsProtectionEquipmentController {

    private ClsProtectionEquipmentRepository repository;

    public ClsProtectionEquipmentController(ClsProtectionEquipmentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsProtectionEquipmentEntity create(@RequestBody ClsProtectionEquipmentEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsProtectionEquipmentEntity read(@PathVariable long id) {
        Optional<ClsProtectionEquipmentEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsProtectionEquipmentEntity update(@RequestBody ClsProtectionEquipmentEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsProtectionEquipmentEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsProtectionEquipmentEntity> findAll() {
        List<ClsProtectionEquipmentEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
