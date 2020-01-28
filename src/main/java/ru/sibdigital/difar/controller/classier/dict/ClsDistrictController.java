package ru.sibdigital.difar.controller.classier.dict;

import org.springframework.web.bind.annotation.*;
import ru.sibdigital.difar.domain.classifier.dict.ClsDistrictEntity;
import ru.sibdigital.difar.repository.classifier.dict.ClsDistrictRepository;

import java.util.Optional;

@RestController
@RequestMapping("/district")
public class ClsDistrictController {

    private ClsDistrictRepository repository;

    public ClsDistrictController(ClsDistrictRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public ClsDistrictEntity create(@RequestBody ClsDistrictEntity entity) {
        ClsDistrictEntity saved = repository.save(entity);
        return saved;
    }

    @GetMapping("/{id}")
    public ClsDistrictEntity read(@PathVariable long id) {
        Optional<ClsDistrictEntity> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @PutMapping("/{id}")
    public ClsDistrictEntity update(@PathVariable long id, @RequestBody ClsDistrictEntity entityToUpdate) {
        ClsDistrictEntity updated = repository.save(entityToUpdate);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        Optional<ClsDistrictEntity> optional = repository.findById(id);
        optional.ifPresent(entity -> repository.delete(entity));
        return optional.isPresent();
    }

}
