package ru.sibdigital.difar.controller.classifier.org;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.org.ClsDepartEntity;
import ru.sibdigital.difar.repository.classifier.org.ClsDepartRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/depart")
public class ClsDepartController {

    private ClsDepartRepository repository;

    public ClsDepartController(ClsDepartRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsDepartEntity create(@RequestBody ClsDepartEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsDepartEntity read(@PathVariable long id) {
        Optional<ClsDepartEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsDepartEntity update(@RequestBody ClsDepartEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsDepartEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsDepartEntity> findAll() {
        List<ClsDepartEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
