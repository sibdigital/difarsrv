package ru.sibdigital.difar.controller.classifier.org;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.org.ClsEmployeeEntity;
import ru.sibdigital.difar.repository.classifier.org.ClsEmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class ClsEmployeeController {

    private ClsEmployeeRepository repository;

    public ClsEmployeeController(ClsEmployeeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsEmployeeEntity create(@RequestBody ClsEmployeeEntity entity) {
        return repository.save(entity);
    }

    @PutMapping("/update")
    public ClsEmployeeEntity update(@RequestBody ClsEmployeeEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsEmployeeEntity read(@PathVariable long id) {
        Optional<ClsEmployeeEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsEmployeeEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsEmployeeEntity> findAll() {
        List<ClsEmployeeEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
