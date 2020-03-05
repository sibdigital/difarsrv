package ru.sibdigital.difar.controller.classifier.accs;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.accs.ClsRoleEntity;
import ru.sibdigital.difar.repository.classifier.accs.ClsRoleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/role")
public class ClsRoleController {

    private ClsRoleRepository repository;

    public ClsRoleController(ClsRoleRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsRoleEntity create(@RequestBody ClsRoleEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsRoleEntity read(@PathVariable long id) {
        Optional<ClsRoleEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsRoleEntity update(@RequestBody ClsRoleEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsRoleEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsRoleEntity> findAll() {
        List<ClsRoleEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
