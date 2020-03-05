package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsGpsModuleEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsGpsModuleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/gps")
public class ClsGpsModuleController {

    private ClsGpsModuleRepository repository;

    public ClsGpsModuleController(ClsGpsModuleRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsGpsModuleEntity create(@RequestBody ClsGpsModuleEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsGpsModuleEntity read(@PathVariable long id) {
        Optional<ClsGpsModuleEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsGpsModuleEntity update(@RequestBody ClsGpsModuleEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsGpsModuleEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsGpsModuleEntity> findAll() {
        List<ClsGpsModuleEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
