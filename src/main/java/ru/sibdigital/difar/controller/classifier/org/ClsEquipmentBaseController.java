package ru.sibdigital.difar.controller.classifier.org;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.org.ClsEquipmentBaseEntity;
import ru.sibdigital.difar.repository.classifier.org.ClsEquipmentBaseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/equipment-base")
public class ClsEquipmentBaseController {

    private ClsEquipmentBaseRepository repository;

    public ClsEquipmentBaseController(ClsEquipmentBaseRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsEquipmentBaseEntity create(@RequestBody ClsEquipmentBaseEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsEquipmentBaseEntity read(@PathVariable long id) {
        Optional<ClsEquipmentBaseEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsEquipmentBaseEntity update(@RequestBody ClsEquipmentBaseEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsEquipmentBaseEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsEquipmentBaseEntity> findAll() {
        List<ClsEquipmentBaseEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
