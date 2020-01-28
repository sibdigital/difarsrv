package ru.sibdigital.difar.controller.classier.accs;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.repository.classifier.accs.ClsUserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class ClsUserController {

    private ClsUserRepository repository;

    public ClsUserController(ClsUserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsUserEntity create(@RequestBody ClsUserEntity entity) {
        ClsUserEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsUserEntity read(@PathVariable long id) {
        Optional<ClsUserEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/{id}")
    public ClsUserEntity update(@PathVariable long id, @RequestBody ClsUserEntity entityToUpdate) {
        ClsUserEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsUserEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
