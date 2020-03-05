package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsOrganizationEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsOrganizationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/organization")
public class ClsOrganizationController {

    private ClsOrganizationRepository repository;

    public ClsOrganizationController(ClsOrganizationRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsOrganizationEntity create(@RequestBody ClsOrganizationEntity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ClsOrganizationEntity read(@PathVariable long id) {
        Optional<ClsOrganizationEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsOrganizationEntity update(@RequestBody ClsOrganizationEntity entityToUpdate) {
        return repository.save(entityToUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsOrganizationEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> {
            entity.setDeleted(true);
            repository.save(entity);
        });
        return optional.isPresent();
    }

    @GetMapping
    public Iterable<ClsOrganizationEntity> findAll() {
        List<ClsOrganizationEntity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target.stream().filter(element -> element.getDeleted() == null || !element.getDeleted()).collect(Collectors.toList());
    }

}
