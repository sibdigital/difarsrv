package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsStandardPeriodEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsStandardPeriodRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/standard-period")
public class ClsStandardPeriodController {

    private ClsStandardPeriodRepository repository;

    public ClsStandardPeriodController(ClsStandardPeriodRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsStandardPeriodEntity create(@RequestBody ClsStandardPeriodEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsStandardPeriodEntity read(@PathVariable long id) {
        Optional<ClsStandardPeriodEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsStandardPeriodEntity update(@RequestBody ClsStandardPeriodEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsStandardPeriodEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsStandardPeriodEntity> findAll() {
        List<ClsStandardPeriodEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
