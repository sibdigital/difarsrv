package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsEquipmentKindEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsEquipmentKindRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/equipment-kind")
public class ClsEquipmentKindController {

    private ClsEquipmentKindRepository repository;

    public ClsEquipmentKindController(ClsEquipmentKindRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsEquipmentKindEntity create(@RequestBody ClsEquipmentKindEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsEquipmentKindEntity read(@PathVariable long id) {
        Optional<ClsEquipmentKindEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsEquipmentKindEntity update(@RequestBody ClsEquipmentKindEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsEquipmentKindEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsEquipmentKindEntity> findAll() {
        List<ClsEquipmentKindEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
