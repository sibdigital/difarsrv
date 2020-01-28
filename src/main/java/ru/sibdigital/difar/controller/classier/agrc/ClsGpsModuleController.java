package ru.sibdigital.difar.controller.classier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsGpsModuleEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsGpsModuleRepository;

import java.util.Optional;

@RestController
@RequestMapping("/gps")
public class ClsGpsModuleController {

    private ClsGpsModuleRepository repository;

    public ClsGpsModuleController(ClsGpsModuleRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsGpsModuleEntity create(@RequestBody ClsGpsModuleEntity entity) {
        ClsGpsModuleEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsGpsModuleEntity read(@PathVariable long id) {
        Optional<ClsGpsModuleEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/{id}")
    public ClsGpsModuleEntity update(@PathVariable long id, @RequestBody ClsGpsModuleEntity entityToUpdate) {
        ClsGpsModuleEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsGpsModuleEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
