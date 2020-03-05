package ru.sibdigital.difar.controller.classifier.agrc;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.agrc.ClsCropEntity;
import ru.sibdigital.difar.repository.classifier.agrc.ClsCropRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/crop")
public class ClsCropController {

    private ClsCropRepository repository;

    public ClsCropController(ClsCropRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsCropEntity create(@RequestBody ClsCropEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsCropEntity read(@PathVariable long id) {
        Optional<ClsCropEntity> optional = repository.findById(id);
        return optional.isPresent() && !optional.get().getDeleted() ? optional.get() : null;
    }

    @PutMapping("/update")
    public ClsCropEntity update(@RequestBody ClsCropEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsCropEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsCropEntity> findAll() {
        List<ClsCropEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
