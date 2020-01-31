package ru.sibdigital.difar.controller.classifier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsOrganizationEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsOrganizationRepository;

import java.util.Optional;

@RestController
@RequestMapping("/organization")
public class ClsOrganizationController {

    private ClsOrganizationRepository repository;

    public ClsOrganizationController(ClsOrganizationRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsOrganizationEntity create(@RequestBody ClsOrganizationEntity entity) {
        ClsOrganizationEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsOrganizationEntity read(@PathVariable long id) {
        Optional<ClsOrganizationEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/update")
    public ClsOrganizationEntity update(@RequestBody ClsOrganizationEntity entityToUpdate) {
        ClsOrganizationEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsOrganizationEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
