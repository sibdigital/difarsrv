package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsVegetPeriodEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsVegetPeriodRepository;

import java.util.Optional;

@RestController
@RequestMapping("veget-period")
public class ClsVegetPeriodController {

    private ClsVegetPeriodRepository repository;

    public ClsVegetPeriodController(ClsVegetPeriodRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsVegetPeriodEntity create(@RequestBody ClsVegetPeriodEntity entity) {
        ClsVegetPeriodEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsVegetPeriodEntity read(@PathVariable long id) {
        Optional<ClsVegetPeriodEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsVegetPeriodEntity update(@RequestBody ClsVegetPeriodEntity entityToUpdate) {
        ClsVegetPeriodEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsVegetPeriodEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
