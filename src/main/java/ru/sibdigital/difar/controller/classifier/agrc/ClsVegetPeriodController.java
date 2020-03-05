package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsVegetPeriodEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsVegetPeriodRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("veget-period")
public class ClsVegetPeriodController {

    private ClsVegetPeriodRepository repository;

    public ClsVegetPeriodController(ClsVegetPeriodRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsVegetPeriodEntity create(@RequestBody ClsVegetPeriodEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsVegetPeriodEntity read(@PathVariable long id) {
        Optional<ClsVegetPeriodEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsVegetPeriodEntity update(@RequestBody ClsVegetPeriodEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsVegetPeriodEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsVegetPeriodEntity> findAll() {
        List<ClsVegetPeriodEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
