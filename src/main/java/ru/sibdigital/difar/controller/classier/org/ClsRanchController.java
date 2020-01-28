package ru.sibdigital.difar.controller.classier.org;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.org.ClsRanchEntity;
import ru.sibdigital.difar.repository.classifier.org.ClsRanchRepository;

import java.util.Optional;

@RestController
@RequestMapping("/ranch")
public class ClsRanchController {

    private ClsRanchRepository repository;

    public ClsRanchController(ClsRanchRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsRanchEntity create(@RequestBody ClsRanchEntity entity) {
        ClsRanchEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsRanchEntity read(@PathVariable long id) {
        Optional<ClsRanchEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/{id}")
    public ClsRanchEntity update(@PathVariable long id, @RequestBody ClsRanchEntity entityToUpdate) {
        ClsRanchEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsRanchEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
