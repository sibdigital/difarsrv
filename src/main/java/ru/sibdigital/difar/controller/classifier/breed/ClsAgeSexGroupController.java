package ru.sibdigital.difar.controller.classifier.breed;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.breed.ClsAgeSexGroupEntity;
import ru.sibdigital.difar.repository.classifier.breed.ClsAgeSexGroupRepository;

import java.util.Optional;

@RestController
@RequestMapping("/age-sex-group")
public class ClsAgeSexGroupController {

    private ClsAgeSexGroupRepository repository;

    public ClsAgeSexGroupController(ClsAgeSexGroupRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsAgeSexGroupEntity create(@RequestBody ClsAgeSexGroupEntity entity) {
        ClsAgeSexGroupEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsAgeSexGroupEntity read(@PathVariable long id) {
        Optional<ClsAgeSexGroupEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsAgeSexGroupEntity update(@RequestBody ClsAgeSexGroupEntity entityToUpdate) {
        ClsAgeSexGroupEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsAgeSexGroupEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
