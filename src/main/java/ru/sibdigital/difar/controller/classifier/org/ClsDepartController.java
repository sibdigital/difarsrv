package ru.sibdigital.difar.controller.classifier.org;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.org.ClsDepartEntity;
import ru.sibdigital.difar.repository.classifier.org.ClsDepartRepository;

import java.util.Optional;

@RestController
@RequestMapping("/depart")
public class ClsDepartController {

    private ClsDepartRepository repository;

    public ClsDepartController(ClsDepartRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsDepartEntity create(@RequestBody ClsDepartEntity entity) {
        ClsDepartEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsDepartEntity read(@PathVariable long id) {
        Optional<ClsDepartEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsDepartEntity update(@RequestBody ClsDepartEntity entityToUpdate) {
        ClsDepartEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsDepartEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
