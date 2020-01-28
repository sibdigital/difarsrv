package ru.sibdigital.difar.controller.classier.org;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.org.ClsEmployeeEntity;
import ru.sibdigital.difar.repository.classifier.org.ClsEmployeeRepository;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class ClsEmployeeController {

    private ClsEmployeeRepository repository;

    public ClsEmployeeController(ClsEmployeeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsEmployeeEntity create(@RequestBody ClsEmployeeEntity entity) {
        ClsEmployeeEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsEmployeeEntity read(@PathVariable long id) {
        Optional<ClsEmployeeEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/{id}")
    public ClsEmployeeEntity update(@PathVariable long id, @RequestBody ClsEmployeeEntity entityToUpdate) {
        ClsEmployeeEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsEmployeeEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
