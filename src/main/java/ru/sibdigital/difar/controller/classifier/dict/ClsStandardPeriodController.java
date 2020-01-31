package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsStandardPeriodEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsStandardPeriodRepository;

import java.util.Optional;

@RestController
@RequestMapping("/standard-period")
public class ClsStandardPeriodController {

    private ClsStandardPeriodRepository repository;

    public ClsStandardPeriodController(ClsStandardPeriodRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsStandardPeriodEntity create(@RequestBody ClsStandardPeriodEntity entity) {
        ClsStandardPeriodEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsStandardPeriodEntity read(@PathVariable long id) {
        Optional<ClsStandardPeriodEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsStandardPeriodEntity update(@RequestBody ClsStandardPeriodEntity entityToUpdate) {
        ClsStandardPeriodEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsStandardPeriodEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
