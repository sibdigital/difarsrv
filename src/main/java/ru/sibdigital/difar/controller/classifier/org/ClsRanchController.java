package ru.sibdigital.difar.controller.classifier.org;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.org.ClsRanchEntity;
import ru.sibdigital.difar.repository.classifier.org.ClsRanchRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ranch")
public class ClsRanchController {

    private ClsRanchRepository repository;

    public ClsRanchController(ClsRanchRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsRanchEntity create(@RequestBody ClsRanchEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsRanchEntity read(@PathVariable long id) {
        Optional<ClsRanchEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsRanchEntity update(@RequestBody ClsRanchEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsRanchEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsRanchEntity> findAll() {
        List<ClsRanchEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
