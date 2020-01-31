package ru.sibdigital.difar.controller.classifier.accs;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.accs.ClsResourceEntity;
import ru.sibdigital.difar.repository.classifier.accs.ClsResourceRepository;

import java.util.Optional;

@RestController
@RequestMapping("/resource")
public class ClsResourceController {

    private ClsResourceRepository repository;

    public ClsResourceController(ClsResourceRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsResourceEntity create(@RequestBody ClsResourceEntity entity) {
        ClsResourceEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsResourceEntity read(@PathVariable long id) {
        Optional<ClsResourceEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsResourceEntity update(@RequestBody ClsResourceEntity entityToUpdate) {
        ClsResourceEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsResourceEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
