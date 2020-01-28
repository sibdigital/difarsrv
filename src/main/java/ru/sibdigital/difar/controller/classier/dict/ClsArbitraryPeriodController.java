package ru.sibdigital.difar.controller.classier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsArbitraryPeriodEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsArbitraryPeriodRepository;

import java.util.Optional;

@RestController
@RequestMapping("/arbitrary-period")
public class ClsArbitraryPeriodController {

    private ClsArbitraryPeriodRepository repository;

    public ClsArbitraryPeriodController(ClsArbitraryPeriodRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsArbitraryPeriodEntity create(@RequestBody ClsArbitraryPeriodEntity entity) {
        ClsArbitraryPeriodEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsArbitraryPeriodEntity read(@PathVariable long id) {
        Optional<ClsArbitraryPeriodEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/{id}")
    public ClsArbitraryPeriodEntity update(@PathVariable long id, @RequestBody ClsArbitraryPeriodEntity entityToUpdate) {
        ClsArbitraryPeriodEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsArbitraryPeriodEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
