package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsArbitraryPeriodEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsArbitraryPeriodRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/arbitrary-period")
public class ClsArbitraryPeriodController {

    private ClsArbitraryPeriodRepository repository;

    public ClsArbitraryPeriodController(ClsArbitraryPeriodRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsArbitraryPeriodEntity create(@RequestBody ClsArbitraryPeriodEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsArbitraryPeriodEntity read(@PathVariable long id) {
        Optional<ClsArbitraryPeriodEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsArbitraryPeriodEntity update(@RequestBody ClsArbitraryPeriodEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsArbitraryPeriodEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsArbitraryPeriodEntity> findAll() {
        List<ClsArbitraryPeriodEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
