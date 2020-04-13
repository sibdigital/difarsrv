package ru.sibdigital.difar.controller.classifier.accs;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.repository.classifier.accs.ClsUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class ClsUserController {

    private ClsUserRepository repository;

    public ClsUserController(ClsUserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsUserEntity create(@RequestBody ClsUserEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsUserEntity read(@PathVariable long id) {
        Optional<ClsUserEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsUserEntity update(@RequestBody ClsUserEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsUserEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsUserEntity> findAll() {
        List<ClsUserEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }
}
