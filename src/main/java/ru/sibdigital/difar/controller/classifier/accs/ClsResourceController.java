package ru.sibdigital.difar.controller.classifier.accs;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.accs.ClsResourceEntity;
import ru.sibdigital.difar.repository.classifier.accs.ClsResourceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resource")
public class ClsResourceController {

    private ClsResourceRepository repository;

    public ClsResourceController(ClsResourceRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsResourceEntity create(@RequestBody ClsResourceEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsResourceEntity read(@PathVariable long id) {
        Optional<ClsResourceEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsResourceEntity update(@RequestBody ClsResourceEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsResourceEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsResourceEntity> findAll() {
        List<ClsResourceEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }
}
