package ru.sibdigital.difar.controller.classier.accs;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.accs.ClsRoleEntity;
import ru.sibdigital.difar.repository.classifier.accs.ClsRoleRepository;

import java.util.Optional;

@RestController
@RequestMapping("/role")
public class ClsRoleController {

    private ClsRoleRepository repository;

    public ClsRoleController(ClsRoleRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsRoleEntity create(@RequestBody ClsRoleEntity entity) {
        ClsRoleEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsRoleEntity read(@PathVariable long id) {
        Optional<ClsRoleEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/{id}")
    public ClsRoleEntity update(@PathVariable long id, @RequestBody ClsRoleEntity entityToUpdate) {
        ClsRoleEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsRoleEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
