package ru.sibdigital.difar.controller.classifier.breed;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.breed.ClsAgeSexGroupEntity;
import ru.sibdigital.difar.repository.classifier.breed.ClsAgeSexGroupRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/age-sex-group")
public class ClsAgeSexGroupController {

    private ClsAgeSexGroupRepository repository;

    public ClsAgeSexGroupController(ClsAgeSexGroupRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsAgeSexGroupEntity create(@RequestBody ClsAgeSexGroupEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsAgeSexGroupEntity read(@PathVariable long id) {
        Optional<ClsAgeSexGroupEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsAgeSexGroupEntity update(@RequestBody ClsAgeSexGroupEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsAgeSexGroupEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsAgeSexGroupEntity> findAll() {
        List<ClsAgeSexGroupEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
