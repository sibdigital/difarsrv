package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsLegalEntityEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsLegalEntityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/legal-entity")
public class ClsLegalEntityController {

    private ClsLegalEntityRepository repository;

    public ClsLegalEntityController(ClsLegalEntityRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsLegalEntityEntity create(@RequestBody ClsLegalEntityEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsLegalEntityEntity read(@PathVariable long id) {
        Optional<ClsLegalEntityEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsLegalEntityEntity update(@RequestBody ClsLegalEntityEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsLegalEntityEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsLegalEntityEntity> findAll() {
        List<ClsLegalEntityEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
