package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsFieldEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsFieldRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/field")
public class ClsFieldController {

    private ClsFieldRepository repository;

    public ClsFieldController(ClsFieldRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsFieldEntity create(@RequestBody ClsFieldEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsFieldEntity read(@PathVariable long id) {
        Optional<ClsFieldEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsFieldEntity update(@RequestBody ClsFieldEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsFieldEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsFieldEntity> findAll() {
        List<ClsFieldEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
